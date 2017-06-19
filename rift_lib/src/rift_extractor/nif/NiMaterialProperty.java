package rift_extractor.nif;

import java.io.IOException;

import javax.vecmath.Point4f;

import com.google.common.io.LittleEndianDataInputStream;

public class NiMaterialProperty extends NiProperty
{
	public Point4f matAmbient;
	public Point4f matDiffuse;
	public Point4f matSpecular;
	public Point4f matEmit;
	public float matShine;
	public float matAlpha;
	public boolean hasMaterialProps;

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		matAmbient = new Point4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), 1.0f);
		matDiffuse = new Point4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), 1.0f);
		matSpecular = new Point4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), 1.0f);
		matEmit = new Point4f(ds.readFloat(), ds.readFloat(), ds.readFloat(), 1.0f);
		matShine = ds.readFloat();
		matAlpha = ds.readFloat();
		hasMaterialProps = true;

	}
}
