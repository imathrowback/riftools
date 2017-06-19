package rift_extractor.nif;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.vecmath.Vector3f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.io.LittleEndianDataInputStream;

public class NiMesh extends NiRenderObject
{

	public int meshPrimType;
	public int numSubMeshes;
	public boolean isInstanced;
	public Vector3f boundsCenter;
	public float boundsRad;
	public int numStreamRefs;
	public LinkedList<NifMeshStream> streamRefs;
	public List<Integer> modLinks;

	public List<String> getStreams()
	{
		List<String> names = new LinkedList<>();
		for (NifMeshStream streamRef : streamRefs)
		{
			for (int i = 0; i < streamRef.elementDescs.size(); i++)
			{
				Pair<String, Integer> pair = streamRef.elementDescs.get(i);
				String elemCheckName = pair.getKey();
				names.add(elemCheckName);
			}
		}
		return names;
	}

	public StreamAndElement getStreamAndElement(final NIFFile file, final String elementName, final int preferredIndex)
	{
		for (NifMeshStream streamRef : streamRefs)
		{
			for (int i = 0; i < streamRef.elementDescs.size(); i++)
			{
				Pair<String, Integer> pair = streamRef.elementDescs.get(i);
				String elemCheckName = pair.getKey();
				Integer elemCheckIndex = pair.getValue();
				if (preferredIndex == -1 || elemCheckIndex == preferredIndex)
				{
					if (elemCheckName.startsWith(elementName))
					{
						NiDataStream dataStream = (NiDataStream) file.getObjects().get(streamRef.streamLinkID);
						if (dataStream == null)
							System.err.println("null dataStream");
						if (dataStream.streamElems == null)
							System.err.println("null dataStream.streamElems: " + dataStream);
						if (i >= dataStream.streamElems.size())
							System.err.println("WARNING: Data stream does not have enough elements.");
						else
						{
							NifStreamElement elem = dataStream.streamElems.get(i);
							return new StreamAndElement(streamRef, elem, dataStream);
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public void parse(final NIFFile file, final NIFObject base, final LittleEndianDataInputStream ds) throws IOException
	{
		super.parse(file, base, ds);

		loadRenderable(file, ds);
		meshPrimType = ds.readInt();
		numSubMeshes = ds.readUnsignedShort();
		isInstanced = ds.readUnsignedByte() > 0;
		boundsCenter = new Vector3f(ds.readFloat(), ds.readFloat(), ds.readFloat());
		boundsRad = ds.readFloat();
		numStreamRefs = ds.readInt();
		streamRefs = new LinkedList<NifMeshStream>();

		for (int i = 0; i < numStreamRefs; i++)
		{
			NifMeshStream meshStream = new NifMeshStream();
			meshStream.parse(file, base, ds);
			streamRefs.add(meshStream);
		}

		modLinks = loadLinkIDs(ds);
		file.addMesh(this);

	}
}
