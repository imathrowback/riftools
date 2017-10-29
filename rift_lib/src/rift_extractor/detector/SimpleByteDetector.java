package rift_extractor.detector;

public class SimpleByteDetector implements Detector
{
	byte[] bytes;
	String ext;
	String description;

	public SimpleByteDetector(final byte[] bs, final String ext, final String description)
	{
		bytes = bs;
		this.ext = ext;
		this.description = description;
	}

	@Override
	public DetectResult detect(final byte[] data)
	{
		if (data.length < bytes.length)
			return DetectResult.NEED_MORE;

		for (int i = 0; i < bytes.length; i++)
			if (data[i] != bytes[i])
				return DetectResult.FALSE;
		return DetectResult.TRUE;

	}

	@Override
	public String getExtension()
	{
		return ext;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

}