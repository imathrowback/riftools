package rift_extractor.nif;

import java.io.IOException;

import com.google.common.io.LittleEndianDataInputStream;

public class NiObjectNET extends NIFObject
{
	protected void loadObjectNET(final NIFFile file, final LittleEndianDataInputStream ds) throws IOException
	{
		name = file.loadString(ds);
		extraDataIDs = loadLinkIDs(ds);
		loadLinkID(ds);
	}
}
