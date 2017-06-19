package rift_extractor.nif;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.vecmath.Point4f;

import com.google.common.io.LittleEndianDataInputStream;

public class NiTexturingProperty extends NiProperty
{
	public int texPropFlags;
	public List<NifTexMap> texList;
	public List<NifTexMap> shaderMapList;

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);
		super.loadObjectNET(file, ds);

		texPropFlags = ds.readUnsignedShort();
		int texListSize = ds.readInt();
		texList = new LinkedList<>();
		for (int i = 0; i < texListSize; i++)
		{
			NifTexMap tex = null;
			boolean hasMap = ds.readUnsignedByte() > 0;
			if (hasMap)
			{
				tex = new NifTexMap();
				tex.parse(file, base, ds);
				if (i == 5)
				{
					tex.bumpLumaScale = ds.readFloat();
					tex.bumpLumaOffset = ds.readFloat();
					tex.bumpMap = new Point4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), ds.readFloat());
				} else if (i == 7)
				{
					tex.offsetMapOfs = ds.readFloat();
				}

			} else
				tex = null;
			texList.add(tex);
		}

		int shaderMapListSize = ds.readInt();
		shaderMapList = new LinkedList<>();
		for (int i = 0; i < shaderMapListSize; i++)
		{
			NifTexMap tex = null;
			boolean hasMap = ds.readUnsignedByte() > 0;
			if (hasMap)
			{
				tex = new NifTexMap();
				tex.parse(file, base, ds);
				tex.uniqueID = ds.readInt();
			}
			shaderMapList.add(tex);
		}

	}
}
