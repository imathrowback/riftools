package rift_extractor.detector;

public class SimpleContainsDetector implements Detector
{
	String str;
	int bytes;
	String ext;
	String description;

	public SimpleContainsDetector(final String string, final int minBytesRequired, final String ext,
			final String description)
	{
		this.description = description;
		str = string;
		bytes = minBytesRequired;
		this.ext = ext;

	}

	@Override
	public DetectResult detect(final byte[] data)
	{
		if (data.length < bytes)
			return DetectResult.NEED_MORE;
		String header = new String(data, 0, bytes);
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