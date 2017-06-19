package rift_extractor.nif;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.google.common.io.LittleEndianDataInputStream;

public class NIFObject
{
	public String typeName;
	public int nifSize;
	public String extraDataString;
	public int parentIndex = -1;
	public int index;
	public String name;
	public List<Integer> extraDataIDs;
	public List<NifStreamElement> streamElems;

	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream dis)
			throws IOException
	{
		nifSize = base.nifSize;
		typeName = base.typeName;
		index = base.index;

	}

	protected int loadLinkID(final LittleEndianDataInputStream ds) throws IOException
	{
		return ds.readInt();

	}

	protected void loadExtraData(final NIFFile file, final LittleEndianDataInputStream ds) throws IOException
	{
		loadObject(file, ds);
		extraDataString = file.loadString(ds);
	}

	private void loadObject(final NIFFile file, final LittleEndianDataInputStream ds)
	{
		// do nothing, unless the file version is < 10.1.0.114 which we don't care about right now
	}

	protected List<Integer> loadLinkIDs(final LittleEndianDataInputStream ds) throws IOException
	{

		int NIF_INVALID_LINK_ID_COUNT = 0xFFFFFFFF;
		int NIF_INVALID_STRING_INDEX = 0xFFFFFFFF;
		int NIF_MAX_SANE_LINK_ID_COUNT = 8192;
		int numLinkIDs = ds.readInt();
		if (numLinkIDs == NIF_INVALID_LINK_ID_COUNT)
			return Collections.emptyList();
		if (numLinkIDs > NIF_MAX_SANE_LINK_ID_COUNT)
			throw new IllegalStateException("Suspicious count");
		List<Integer> ids = new LinkedList<>();
		for (int i = 0; i < numLinkIDs; i++)
			ids.add(ds.readInt());

		return ids;
	}

}