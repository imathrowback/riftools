/*
 *
 */
package org.imathrowback.telaradb;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Cache;
import com.google.common.io.LittleEndianDataInputStream;
import com.sun.jna.Native;
import com.thoughtworks.xstream.XStream;

import rift_extractor.util.Leb128;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.Pair;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class TelaraDB implements TelaraDBInterface
{
	private static final Logger logger = Logger.getLogger(TelaraDB.class.getName());
	Table<?> dataset = DSL.tableByName("dataset");
	Table<?> datasetCompression = DSL.tableByName("dataset_compression");
	Field<Integer> ds_ID = DSL.fieldByName(SQLDataType.INTEGER, "datasetId");
	Field<Integer> ds_KEY = DSL.fieldByName(SQLDataType.INTEGER, "datasetKey");
	Field<String> ds_NAME = DSL.fieldByName(SQLDataType.VARCHAR, "name");
	Field<byte[]> ds_VALUE = DSL.fieldByName(SQLDataType.BLOB, "value");
	Field<byte[]> ds_FREQ = DSL.fieldByName(SQLDataType.BLOB, "frequencies");
	Map<Integer, Boolean> compressedMap = new TreeMap<>();

	TelaraDBDecomp decomp;
	Connection con;
	Object lock = new Object();

	LoadingCache<Long, List<Record2<Integer, Integer>>> idsAndKeysWithKeyCache;
	Cache<Integer, byte[]> freqTable = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.MINUTES).build();

	public TelaraDB(final Connection c)
	{

		CacheLoader<Long, List<Record2<Integer, Integer>>> loader = new CacheLoader<Long, List<Record2<Integer, Integer>>>() {
			@Override
			public List<Record2<Integer, Integer>> load(final Long key) throws Exception
			{
				try
				{
					DSLContext ctx = DSL.using(con);
					return ctx.select(ds_ID, ds_KEY).from(dataset).where(ds_KEY.eq(key.intValue())).fetchStream()
							.collect(Collectors.toList());
				} catch (Exception ex)
				{
					ex.printStackTrace();
					return Collections.emptyList();
				}
			}
		};
		idsAndKeysWithKeyCache = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.MINUTES).build(loader);
		con = c;
		try
		{
			System.loadLibrary("riftdecomp");
			decomp = Native.loadLibrary("riftdecomp", TelaraDBDecomp.class);
		} catch (ClassCastException ex)
		{
			ex.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.imathrowback.telaradb.TelaraDBInterface#getIdsAndKeys()
	 */
	@Override
	public Stream<Pair<Integer, Integer>> getIdsAndKeys()
	{
		try
		{
			DSLContext ctx = DSL.using(con);
			Stream<Record2<Integer, Integer>> stream = ctx.select(ds_ID, ds_KEY).from(dataset).orderBy(ds_ID, ds_KEY)
					.fetchStream();
			return stream.map(r -> Pair.of(r.value1(), r.value2()));
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return Stream.empty();
		}
	}

	public List<Record2<Integer, Integer>> matchIdsAndKeysWithKey(final long key)
	{
		try
		{
			return idsAndKeysWithKeyCache.get(key);
		} catch (ExecutionException ex)
		{
			return Collections.emptyList();
		}
	}

	public boolean isCompressed(final Integer datasetid)
	{
		if (compressedMap.containsKey(datasetid))
			return compressedMap.get(datasetid);
		DSLContext ctx = DSL.using(con);
		boolean b = ctx.selectCount().from(datasetCompression).where(ds_ID.eq(datasetid)).fetchOne().value1() > 0;
		compressedMap.put(datasetid, b);
		return b;
	}

	public synchronized byte[] getFreqTable(final Integer datasetid)
	{
		try
		{
			return freqTable.get(datasetid, () -> {
				DSLContext ctx = DSL.using(con);
				return ctx.select(ds_FREQ).from(datasetCompression).where(ds_ID.eq(datasetid)).fetchOne().value1();
			});
		} catch (ExecutionException ex)
		{

			DSLContext ctx = DSL.using(con);
			return ctx.select(ds_FREQ).from(datasetCompression).where(ds_ID.eq(datasetid)).fetchOne().value1();
		}
	}

	public byte[] getCompressedData(final Integer datasetid, final Integer key)
	{
		DSLContext ctx = DSL.using(con);
		return ctx.select(ds_VALUE).from(dataset).where(ds_ID.eq(datasetid).and(ds_KEY.eq(key))).fetchOne().value1();
	}

	/** Get an XML representation of the data associated with the given id and key */
	public String getXML(final Integer datasetid, final Integer key)
	{
		byte[] data = getData(datasetid, key);

		XStream stream = new XStream();
		stream.processAnnotations(CObject.class);
		stream.autodetectAnnotations(true);

		try
		{
			CObject root = DatParser.processFileAndObject(new ByteArrayInputStream(data));
			return stream.toXML(root);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return "";
		}
	}

	/* (non-Javadoc)
	 * @see org.imathrowback.telaradb.TelaraDBInterface#getData(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public byte[] getData(final Integer datasetid, final Integer key)
	{
		byte[] freqData = getFreqTable(datasetid);
		byte[] compresseddata = getCompressedData(datasetid, key);

		try
		{
			ByteArrayInputStream instr = new ByteArrayInputStream(compresseddata);
			LittleEndianDataInputStream dis = new LittleEndianDataInputStream(instr);
			int uncompressedSize = Leb128.readUnsignedLeb128_X(dis).get();
			int compressedSize = instr.available();
			byte[] inputData = new byte[compressedSize];
			dis.read(inputData);
			byte[] outputdata = new byte[uncompressedSize];
			if (inputData.length == 0)
				return new byte[0];
			synchronized (lock)
			{
				decomp.decompressData(freqData, inputData, inputData.length, outputdata, outputdata.length);
			}
			return outputdata;
		} catch (java.lang.Error ex)
		{
			System.err.println("Native DLL error while attempting to get data for " + datasetid + ":" + key + ":"
					+ ex.getMessage());
			return new byte[0];
		} catch (Exception ex)
		{
			System.err
					.println("Error while attempting to get data for " + datasetid + ":" + key + ":" + ex.getMessage());
			return new byte[0];
		}
	}

}
