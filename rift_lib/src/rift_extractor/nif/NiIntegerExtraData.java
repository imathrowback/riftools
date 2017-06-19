package rift_extractor.nif;

import java.io.IOException;

import com.google.common.io.LittleEndianDataInputStream;

public class NiIntegerExtraData extends NIFObject
{
	public int intExtraData;

	public NiIntegerExtraData()
	{

	}

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		loadExtraData(file, ds);
		intExtraData = ds.readInt();

	}

}
