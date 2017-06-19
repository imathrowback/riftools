package rift_extractor.nif;

import java.io.IOException;

import com.google.common.io.LittleEndianDataInputStream;

public class NiStringExtraData extends NIFObject
{
	public String stringExtraData;

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		loadExtraData(file, ds);
		stringExtraData = file.loadString(ds);

	}
}
