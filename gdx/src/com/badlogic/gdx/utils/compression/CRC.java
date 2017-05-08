// SevenZip/CRC.java

package com.badlogic.gdx.utils.compression;

public class CRC {
	final static int TABLE_LENGTH = 256;
	final static int BYTE = 8;

	static public int[] Table = new int[TABLE_LENGTH];

	static {
		for (int i = 0; i < TABLE_LENGTH; i++) {
			int r = i;
			for (int j = 0; j < BYTE; j++)
				if ((r & 1) != 0)
					r = (r >>> 1) ^ 0xEDB88320;
				else
					r >>>= 1;
			Table[i] = r;
		}
	}

	int _value = -1;

	public void Init () {
		_value = -1;
	}

	public void Update (byte[] data, int offset, int size) {
		for (int i = 0; i < size; i++)
			_value = Table[(_value ^ data[offset + i]) & 0xFF] ^ (_value >>> BYTE);
	}

	public void Update (byte[] data) {
		int size = data.length;
		for (int i = 0; i < size; i++)
			_value = Table[(_value ^ data[i]) & 0xFF] ^ (_value >>> BYTE);
	}

	public void UpdateByte (int b) {
		_value = Table[(_value ^ b) & 0xFF] ^ (_value >>> BYTE);
	}

	public int GetDigest () {
		return _value ^ (-1);
	}
}
