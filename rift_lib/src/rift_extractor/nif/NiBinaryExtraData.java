package rift_extractor.nif;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

import com.google.common.io.LittleEndianDataInputStream;

public class NiBinaryExtraData extends NIFObject
{
	int binaryDataSize;
	public byte[] extraData = new byte[0];
	public byte[] decompressed;

	public NiBinaryExtraData()
	{

	}

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		loadExtraData(file, ds);
		binaryDataSize = ds.readInt();
		if (binaryDataSize > 0)
		{
			extraData = new byte[binaryDataSize];
			ds.readFully(extraData);
			tryDecompress();
		}
	}

	/** return true if the data was compressed */
	public boolean wasCompressed()
	{
		return decompressed != null;
	}

	/** Try to the decompress the data if possible, otherwise fail silently */
	private void tryDecompress()
	{
		try (DeflateCompressorInputStream dis = new DeflateCompressorInputStream(new ByteArrayInputStream(extraData)))
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			IOUtils.copy(dis, bos);
			decompressed = bos.toByteArray();
		} catch (Exception ex)
		{

		}

	}

}
