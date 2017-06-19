package rift_extractor.nif;

public class StreamAndElement
{
	final public NifMeshStream streamRef;
	final public NifStreamElement elem;
	final public NiDataStream dataStream;

	public StreamAndElement(final NifMeshStream streamRef, final NifStreamElement elem2, final NiDataStream dataStream)
	{
		this.streamRef = streamRef;
		elem = elem2;
		this.dataStream = dataStream;
	}

}