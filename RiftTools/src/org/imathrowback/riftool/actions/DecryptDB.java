package org.imathrowback.riftool.actions;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.imathrowback.telaradb.TelaraDBUtil;
import org.kohsuke.args4j.Option;

public class DecryptDB extends RiftAction
{
	@Option(name = "-filename", usage = "The filename", required = true)
	File filename;

	public DecryptDB()
	{

	}

	@Override
	public void go()
	{
		try
		{
			byte[] data = java.nio.file.Files.readAllBytes((filename).toPath());
			byte[] decrypted = new byte[data.length];
			TelaraDBUtil.decrypt(data, data.length, decrypted);
			FileUtils.writeByteArrayToFile((filename), decrypted);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
