package rift_extractor.nif;

import java.io.IOException;
import java.util.List;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;

import com.google.common.io.LittleEndianDataInputStream;

public class NiAVObject extends NiObjectNET
{
	public Matrix4f matrix;
	public float scale;
	public List<Integer> nodePropertyIDs;
	public boolean isBone;

	protected void loadAVObject(final NIFFile file, final LittleEndianDataInputStream ds) throws IOException
	{
		loadObjectNET(file, ds);
		int flags = ds.readUnsignedShort();
		// if hack readUShort
		Vector3f translation = new Vector3f(ds.readFloat(), ds.readFloat(), ds.readFloat());
		matrix = new Matrix4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), 0,
				ds.readFloat(), ds.readFloat(), ds.readFloat(), 0,
				ds.readFloat(), ds.readFloat(), ds.readFloat(), 0,
				translation.x, translation.y, translation.z, 0);
		scale = ds.readFloat();
		nodePropertyIDs = loadLinkIDs(ds);
		loadLinkID(ds); // collision node?
		isBone = true;
	}

}
