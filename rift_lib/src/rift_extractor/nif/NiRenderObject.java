package rift_extractor.nif;

import java.io.IOException;
import java.util.LinkedList;

import com.google.common.io.LittleEndianDataInputStream;

public class NiRenderObject extends NiAVObject
{
	public int numMaterials;
	public LinkedList<Integer> materialExtraData;
	public LinkedList<String> materialNames;
	public int materialIndex;
	public boolean materialNeedsUpdate;

	protected void loadRenderable(final NIFFile file, final LittleEndianDataInputStream ds) throws IOException
	{
		loadAVObject(file, ds);
		numMaterials = ds.readInt();
		materialExtraData = new LinkedList<>();
		materialNames = new LinkedList<String>();
		for (int i = 0; i < numMaterials; i++)
		{
			int matNameIndex = ds.readInt();
			String matName = file.getStringFromTable(matNameIndex);
			materialExtraData.add(ds.readInt());
			materialNames.add(matName);
		}
		materialIndex = ds.readInt();
		materialNeedsUpdate = ds.readUnsignedByte() > 0;

	}
}
