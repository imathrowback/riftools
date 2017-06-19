/**
 *   Copyright 2014 Prasanth Jayachandran
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hasher;

import java.nio.ByteBuffer;
import rift_extractor.util.Util;

/**
 * FNV1 32 and 64 bit variant
 * 32 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_32.c
 * 64 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_64.c
 */
public class FNV1
{
	private static final int FNV1_32_INIT = 0x811c9dc5;
	private static final int FNV1_PRIME_32 = 16777619;
	private static final long FNV1_64_INIT = 0xcbf29ce484222325L;
	private static final long FNV1_PRIME_64 = 1099511628211L;

	/**
	 * FNV1 32 bit variant.
	 *
	 * @param data - input byte array
	 * @return - hashcode
	 */
	public static int hash32(final byte[] data)
	{
		return hash32(data, data.length);
	}

	/**
	 * FNV1 32 bit variant.
	 *
	 * @param data - input byte array
	 * @param length - length of array
	 * @return - hashcode
	 */
	public static int hash32(final byte[] data, final int length)
	{
		int hash = FNV1_32_INIT;
		for (int i = 0; i < length; i++)
		{
			hash *= FNV1_PRIME_32;
			hash ^= (data[i] & 0xff);
		}

		return hash;
	}

	/**
	 * FNV1 32 bit variant.
	 *
	 * @param data - input byte array
	 * @param length - length of array
	 * @return - hashcode
	 */
	public static int hash32W(final byte[] data)
	{
		int hash = FNV1_32_INIT;

		ByteBuffer buf = ByteBuffer.wrap(data);//.order(ByteOrder.LITTLE_ENDIAN);
		buf.getShort();
		System.out.println(Util.bytesToHexString(data));

		for (int i = 0; i < data.length / 2; i++)
		{
			short w = buf.getShort();// & 0xFFFF;
			hash = FNV1_PRIME_32 * (hash ^ w);
			if (buf.remaining() == 1)
				return FNV1_PRIME_32 * (hash ^ (buf.get() & 0xff));
		}

		return hash;
	}

	/**
	 * FNV1 64 bit variant.
	 *
	 * @param data - input byte array
	 * @return - hashcode
	 */
	public static long hash64(final byte[] data)
	{
		return hash64(data, data.length);
	}

	/**
	 * FNV1 64 bit variant.
	 *
	 * @param data - input byte array
	 * @param length - length of array
	 * @return - hashcode
	 */
	public static long hash64(final byte[] data, final int length)
	{
		long hash = FNV1_64_INIT;
		for (int i = 0; i < length; i++)
		{
			hash *= FNV1_PRIME_64;
			hash ^= (data[i] & 0xff);
		}

		return hash;
	}
}
