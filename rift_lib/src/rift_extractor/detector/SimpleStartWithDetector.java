package rift_extractor.detector;

public class SimpleStartWithDetector implements Detector
{
	String str;
	String ext;
	String description;

	public SimpleStartWithDetector(final String string, final String ext,
			final String description)
	{
		this.description = description;
		str = string;
		this.ext = ext;
	}

	@Override
	public DetectResult detect(final byte[] data)
	{
		if (data.length < str.length())
			return DetectResult.NEED_MORE;
		String header = new String(data);
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