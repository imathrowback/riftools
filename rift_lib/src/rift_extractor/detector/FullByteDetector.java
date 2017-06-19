package rift_extractor.detector;

public class FullByteDetector implements Detector
{
	byte[] bytes;
	String ext;
	String description;
	int limit = -1;

	public FullByteDetector(final byte[] bytes, final String string, final String description)
	{
		this.description = description;
		this.bytes = bytes;
		ext = string;
	}

	public FullByteDetector(final byte[] bytes, final String string, final String description, final int limit)
	{
		this.description = description;
		this.bytes = bytes;
		ext = string;
	}

	@Override
	public DetectResult detect(final byte[] data)
	{
		String header = new String(data);
		String str = new String(bytes);
		if (header.contains(str))
			return DetectResult.TRUE;
		return DetectResult.FALSE;

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