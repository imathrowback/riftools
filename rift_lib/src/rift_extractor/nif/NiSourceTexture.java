package rift_extractor.nif;

import java.io.IOException;

import com.google.common.io.LittleEndianDataInputStream;

public class NiSourceTexture extends NiTexture
{
	public String texFilename;
	private boolean externalTex;
	private int pixLinkID;
	private int mipMapped;
	private int alphaFormat;
	private boolean texStatic;
	private int texIndex;

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		loadObjectNET(file, ds);

		externalTex = ds.readUnsignedByte() > 0;
		texFilename = file.loadString(ds);
		pixLinkID = ds.readInt();
		mipMapped = ds.readInt();
		alphaFormat = ds.readInt();
		texStatic = ds.readUnsignedByte() > 0;
		int unk1 = ds.readUnsignedByte();
		int unk2 = ds.readUnsignedByte();
		texIndex = -1;
		file.addTexture(this);

	}
}
