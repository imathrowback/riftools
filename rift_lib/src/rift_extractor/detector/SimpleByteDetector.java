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
		String header = new String(data);
		String str = new String(bytes);
		if (header.length() < str.length())
			return DetectResult.NEED_MORE;
		if (header.startsWith(str))
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