package com.wondersgroup.framework.util;

import javax.xml.bind.DatatypeConverter;

/**
 * 银联标准Mac 算法
 */
public class MacEcbUtils {

	/**
	 * mac计算
	 * 
	 * @param key
	 *            mac秘钥
	 * @param Input
	 *            待加密数据
	 * @return
	 */
	public static byte[] getMac(byte[] key, byte[] Input) {
		int length = Input.length;
		int x = length % 8;
		// 需要补位的长度
		int addLen = 0;
		if (x != 0) {
			addLen = 8 - length % 8;
		}
		int pos = 0;
		// 原始数据补位后的数据
		byte[] data = new byte[length + addLen];
		System.arraycopy(Input, 0, data, 0, length);
		byte[] oper1 = new byte[8];
		System.arraycopy(data, pos, oper1, 0, 8);
		pos += 8;
		// 8字节异或
		for (int i = 1; i < data.length / 8; i++) {
			byte[] oper2 = new byte[8];
			System.arraycopy(data, pos, oper2, 0, 8);
			byte[] t = bytesXOR(oper1, oper2);
			oper1 = t;
			pos += 8;
		}
		// 将异或运算后的最后8个字节（RESULT BLOCK）转换成16个HEXDECIMAL：
		byte[] resultBlock = bytesToHexString(oper1).getBytes();
		// 取前8个字节MAK加密
		byte[] front8 = new byte[8];
		System.arraycopy(resultBlock, 0, front8, 0, 8);
		byte[] behind8 = new byte[8];
		System.arraycopy(resultBlock, 8, behind8, 0, 8);
		byte[] desfront8 = DESUtil.encrypt(front8, key);
		// 将加密后的结果与后8 个字节异或：
		byte[] resultXOR = bytesXOR(desfront8, behind8);
		// 用异或的结果TEMP BLOCK 再进行一次单倍长密钥算法运算
		byte[] buff = DESUtil.encrypt(resultXOR, key);
		// 将运算后的结果（ENC BLOCK2）转换成16 个HEXDECIMAL asc
		byte[] retBuf = new byte[8];
		// 取8个长度字节就是mac值
		System.arraycopy(bytesToHexString(buff).getBytes(), 0, retBuf, 0, 8);
		return retBuf;
	}

	public static String getMac_icbc(byte[] Input) {
		int i, len, j, k, mod1;
		byte[] tmpstr = new byte[8];

		len = Input.length;
		k = len / 8;
		mod1 = len % 8;

		byte[][] macstr = new byte[k + (mod1 > 0 ? 1 : 0)][8];

		for (i = 0; i < k; i++) {
			System.arraycopy(Input, 8 * i, macstr[i], 0, 8);
		}
		System.arraycopy(Input, 8 * k, macstr[k], 0, mod1);

		for (j = mod1; j < 8; j++) {
			macstr[k][j] = 0x20;
		}
		tmpstr = macstr[0];
		for (i = 1; i < macstr.length; i++) {
			tmpstr = bytesXOR(tmpstr, macstr[i]);
		}
		StringBuffer sb = new StringBuffer(32);
		for (i = 0; i < 8; i++) {
			sb.append(String.format("%02x", tmpstr[i]));
		}
		return sb.toString();
	}

	

	/**
	 * 单字节异或
	 * 
	 * @param src1
	 * @param src2
	 * @return
	 */
	public static byte byteXOR(byte src1, byte src2) {
		return (byte) ((src1 & 0xFF) ^ (src2 & 0xFF));
	}

	/**
	 * 字节数组异或
	 * 
	 * @param src1
	 * @param src2
	 * @return
	 */
	public static byte[] bytesXOR(byte[] src1, byte[] src2) {
		int length = src1.length;
		if (length != src2.length) {
			return null;
		}
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = byteXOR(src1[i], src2[i]);
		}
		return result;
	}

	/**
	 * 字节数组转HEXDECIMAL
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}


	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte[] abt = new byte[len];
		if (len >= 2) {
			len /= 2;
		}

		byte[] bbt = new byte[len];
		abt = asc.getBytes();

		for (int p = 0; p < asc.length() / 2; ++p) {
			int j;
			if (abt[2 * p] >= 97 && abt[2 * p] <= 122) {
				j = abt[2 * p] - 97 + 10;
			} else if (abt[2 * p] >= 65 && abt[2 * p] <= 90) {
				j = abt[2 * p] - 65 + 10;
			} else {
				j = abt[2 * p] - 48;
			}

			int k;
			if (abt[2 * p + 1] >= 97 && abt[2 * p + 1] <= 122) {
				k = abt[2 * p + 1] - 97 + 10;
			} else if (abt[2 * p + 1] >= 65 && abt[2 * p + 1] <= 90) {
				k = abt[2 * p + 1] - 65 + 10;
			} else {
				k = abt[2 * p + 1] - 48;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}
}