/*
 * 
 */
package org.imathrowback.telaradb;

import com.sun.jna.Library;

public interface TelaraDBDecomp extends Library
{
	 void decompressData(byte[] frequencyData, byte[] data, int compressedSize, byte[] dataOutput, int decompressedSize);
}
