package rift_extractor.nif;

import java.io.IOException;

import javax.vecmath.Point2f;
import javax.vecmath.Point3f;
import javax.vecmath.Point4f;

import com.google.common.io.LittleEndianDataInputStream;

public class NifTexMap
{
	public float bumpLumaScale;
	public float bumpLumaOffset;
	public Point4f bumpMap;
	public float offsetMapOfs;
	public int sourceTexLinkID;
	private int flags;
	private int maxAniso;
	private boolean hasTransform;
	private Point3f translation;
	private float scale;
	private float rotate;
	private int method;
	private Point2f center;
	public int uniqueID;

	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		sourceTexLinkID = ds.readInt();
		flags = ds.readUnsignedShort();
		maxAniso = ds.readUnsignedShort();
		hasTransform = ds.readUnsignedByte() > 0;
		if (hasTransform)
		{
			translation = new Point3f(ds.readFloat(), ds.readFloat(), ds.readFloat());
			scale = ds.readFloat();
			rotate = ds.readFloat();
			method = ds.readInt();
			center = new Point2f(ds.readFloat(), ds.readFloat());
		}

	}
}
