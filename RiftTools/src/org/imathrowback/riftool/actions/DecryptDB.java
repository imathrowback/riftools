package org.imathrowback.riftool.actions;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.imathrowback.telaradb.TelaraDBUtil;
import org.kohsuke.args4j.Option;

public class DecryptDB extends RiftAction
{
	@Option(name = "-filename", usage = "The filename to decrypt", required = true)
	File filename;

	@Option(name = "-filenameOut", usage = "The filename to decrypt to, if not specified the file will be decrypted in place", required = false)
	File filenameOut;

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
			File out = filename;
			if (filenameOut != null)
				out = filenameOut;
			FileUtils.writeByteArrayToFile((out), decrypted);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
