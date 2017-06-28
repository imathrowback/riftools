package org.imathrowback.telaradb;

import java.io.*;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import com.google.common.io.LittleEndianDataOutputStream;

public class TelaraDBUtil
{
	public static void decrypt(final byte[] data, final int length, final byte[] decrypted)
	{
		try (ByteArrayOutputStream decryptedBOS = new ByteArrayOutputStream(length))
		{
			byte[] key0 = new byte[32];
			byte[] key1 = new byte[32];
			try (InputStream keyFileStream = TelaraDBUtil.class.getResourceAsStream("db_key"))
			{
				keyFileStream.read(key0);
				keyFileStream.read(key1);
			}

			try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data)))
			{
				dis.mark(100);
				dis.skip(16);
				int pagesize = dis.readShort();
				System.out.println("page size:" + pagesize);

				dis.reset();
				try (BufferedOutputStream bbos = new BufferedOutputStream(decryptedBOS))
				{
					int pagecount = data.length / pagesize;
					for (int i = 1; i < pagecount + 1; i++)
					{
						// the iv is the page number
						byte[] iv;
						try (ByteArrayOutputStream bos = new ByteArrayOutputStream(16))
						{
							try (LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(bos))
							{
								dos.writeLong(i);
								dos.writeLong(0);
							}
							iv = bos.toByteArray();
						}

						// initialize a new block cipher using OFB
						BufferedBlockCipher c = new BufferedBlockCipher(new OFBBlockCipher(new AESEngine(), 128));
						CipherParameters params = new ParametersWithIV(new KeyParameter(key0), iv);
						c.init(false, params);

						byte[] bdata = new byte[pagesize];
						dis.read(bdata);
						byte[] ddata = new byte[pagesize];
						c.processBytes(bdata, 0, bdata.length, ddata, 0);
						// bytes 16-23 on the first page are NOT encrypted, so we need to replace them once we decrypt the page
						if (i == 1)
						{
							for (int x = 16; x <= 23; x++)
							{
								ddata[x] = bdata[x];
							}
						}
						bbos.write(ddata);

					}
				}
			}
			System.arraycopy(decryptedBOS.toByteArray(), 0, decrypted, 0, length);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			;
		}
	}
}
