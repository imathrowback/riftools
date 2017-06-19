package rift_extractor.detector;

public interface Detector
{
	public String getExtension();

	DetectResult detect(byte[] data);

	public String getDescription();
}