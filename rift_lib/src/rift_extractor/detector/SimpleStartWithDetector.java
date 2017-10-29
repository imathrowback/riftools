package rift_extractor.detector;

public class SimpleStartWithDetector implements Detector
{
	byte[] bytes;
	String str;
	String ext;
	String description;

	public SimpleStartWithDetector(final String string, final String ext,
			final String description)
	{
		this.description = description;
		str = string;
		bytes = str.getBytes();
		this.ext = ext;
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