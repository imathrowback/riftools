import java.io.IOException;
import java.util.Map;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;

public class RiftTool
{
	public static void main(final String args[]) throws IOException
	{
		System.out.println("RiftTool");
		Map<Integer, PatchInfo> patches = RemotePAK.getPatches(ReleaseType.LIVE);
		System.out.println(patches);

	}
}
