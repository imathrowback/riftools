package rift_extractor.nif;

import java.io.IOException;
import java.util.List;

import com.google.common.io.LittleEndianDataInputStream;

public class NiNode extends NiAVObject
{

	public List<Integer> childLinks;

	public NiNode()
	{

	}

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);
		loadAVObject(file, ds);
		childLinks = loadLinkIDs(ds);
		loadLinkIDs(ds);

	}

}
