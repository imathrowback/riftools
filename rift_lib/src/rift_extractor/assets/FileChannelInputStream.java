package rift_extractor.assets;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelInputStream extends InputStream
{
	FileChannel fc;
	int off;
	int len;
	int sOff;

	public FileChannelInputStream(final FileChannel fc, final int off, final int len)
	{
		sOff = 0;
		this.off = off;
		this.len = len;
		this.fc = fc;
	}

	@Override
	public int read() throws IOException
	{
		if (sOff > len)
			throw new EOFException();
		ByteBuffer data = ByteBuffer.allocate(1);
		int bytes = fc.read(data, off + (sOff++));
		if (bytes == -1)
			return -1;
		return data.array()[0];
	}

	@Override
	public int read(final byte[] bytes, final int off, final int len) throws IOException
	{
		int offset = this.off + sOff;
		int size = Math.min(len, len - sOff);

		ByteBuffer data = ByteBuffer.allocate(size);
		int x = fc.read(data, offset);
		sOff += x;
		System.arraycopy(data.array(), 0, bytes, off, x);
		return x;
	}
}
