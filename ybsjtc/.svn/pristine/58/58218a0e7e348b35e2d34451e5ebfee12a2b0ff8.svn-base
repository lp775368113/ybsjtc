package com.wondersgroup.framework.util;

/**
 * 通用实用程序类.
 * 
 * @author xiutong
 * 
 */
public class CommUtil {
	/**
	 * 字节数组转换成16进制字符串函数.
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字符串
	 * 
	 */
	public static String bytes2HexStr(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * 16进制字符串转换成字符串函数.
	 * 
	 * @param hexStr
	 *            16进制字符串
	 * @return 字符串
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	/**
	 * 字符串转换成字节数组函数.
	 * 
	 * @param s
	 *            字符串
	 * @return 字节数组
	 */
	public static byte[] str2Bytes(String s) {
		int byteArrayLength = s.length() / 2;
		byte[] b = new byte[byteArrayLength];
		for (int i = 0; i < byteArrayLength; i++) {
			byte b0 = (byte) Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16)
					.intValue();
			b[i] = b0;
		}

		return b;
	}
	
	/**
	 * 16进制串转换成10进制字节数组函数.
	 * 
	 * @param s 16进制字符串
	 * @return 10进制字节数组
	 */
	public static byte[] HexStr2Bytes(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return baKeyword;
	}

}
