package com.wondersgroup.framework.upms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecureUtil {
	/**
	 * 加密方式
	 */
	public enum ChpMode {
		AES, // AES/ECB/PKCS5Padding
		MD5, //
		DES, //
		TDES, // 3DES(CBC/PKCS5Padding)
		AES_CBC_P5, // CBC/PKCS5Padding)
		SHA256
	};

	private final static byte[] AES_IV = "RVJXRTkwV0VXRVc=".getBytes();
	private final static byte[] TDES_IV = "MjEyMWl+".getBytes();
	private final static String AES_KEY_ALGORITHM = "AES";
	private final static String TDES_KEY_ALGORITHM = "DESede";
	private final static String ENCODING = "UTF-8";

	/**
	 * 加密
	 * 
	 * @param cm
	 * @param message
	 * @param sKey
	 * @return
	 */
	public static String encrypt(ChpMode cm, String message, String sKey) {
		String ret = "";

		try {
			switch (cm) {
			case AES:
				ret = parseByte2HexStr(AESEncode(message, sKey, "AES/ECB/PKCS5Padding", AES_IV, true));
				break;
			case AES_CBC_P5:
				ret = parseByte2HexStr(AESEncode(message, sKey, "AES/CBC/PKCS5Padding", AES_IV, false));
				break;
			case MD5:
				ret = MD5Encode(message);
				break;
			case TDES:
				ret = parseByte2HexStr(TDESEncode(message, sKey, "DESede/CBC/PKCS5Padding", TDES_IV, false));
				break;
			case SHA256:
				ret = parseByte2HexStr(SHA(message, "SHA-256"));
				break;
			default:
				break;
			}
		} catch (Exception err) {
			err.printStackTrace();
		}

		return ret;
	}

	/**
	 * 解密
	 * 
	 * @param cm
	 * @param message
	 * @param sKey
	 * @return
	 */
	public static String decrypt(ChpMode cm, String message, String sKey) throws Exception {
		String ret = "";

		switch (cm) {
		case AES:
			ret = new String(AESDecode(parseHexStr2Byte(message), sKey, "AES/ECB/PKCS5Padding", AES_IV, true),
					ENCODING);
			break;
		case AES_CBC_P5:
			ret = new String(AESDecode(parseHexStr2Byte(message), sKey, "AES/CBC/PKCS5Padding", AES_IV, false),
					ENCODING);
			break;
		case TDES:
			ret = new String(TDESDecode(parseHexStr2Byte(message), sKey, "DESede/CBC/PKCS5Padding", TDES_IV, false),
					ENCODING);
			break;
		default:
			break;
		}
		return ret;
	}

	/**
	 * MD5加密
	 * 
	 * @param input
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String MD5Encode(String input) throws Exception {
		// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		// 输入的字符串转换成字节数组
		byte[] inputByteArray = input.getBytes(ENCODING);
		// inputByteArray是输入字符串转换得到的字节数组
		messageDigest.update(inputByteArray);
		// 转换并返回结果，也是字节数组，包含16个元素
		byte[] resultByteArray = messageDigest.digest();
		// 字符数组转换成字符串返回
		return parseByte2HexStr(resultByteArray);
	}

	/**
	 * AES 加密
	 * 
	 * @param message
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] AESEncode(String message, String sKey, String chpAlgorithm, byte[] iv, boolean isEbc)
			throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(AES_KEY_ALGORITHM);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(sKey.getBytes(ENCODING));
		kgen.init(128, random);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES_KEY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(chpAlgorithm);// 创建密码器
		byte[] byteContent = message.getBytes(ENCODING);

		if (!isEbc) {
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));// 初始化
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
		}
		return cipher.doFinal(byteContent);
	}

	/**
	 * AES解密
	 * 
	 * @param message
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] AESDecode(byte[] message, String sKey, String chpAlgorithm, byte[] iv, boolean isEbc)
			throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(AES_KEY_ALGORITHM);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(sKey.getBytes(ENCODING));
		kgen.init(128, random);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES_KEY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(chpAlgorithm);// 创建密码器

		if (!isEbc) {
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));// 初始化
		} else {
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		}
		return cipher.doFinal(message);
	}

	/**
	 * 3des解密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] TDESDecode(byte[] message, String key, String chpAlgorithm, byte[] iv, boolean isEbc)
			throws Exception {
		byte[] keybyte = buildTDESKey(key);
		SecretKey deskey = new SecretKeySpec(keybyte, TDES_KEY_ALGORITHM);
		// 解密
		Cipher c1 = Cipher.getInstance(chpAlgorithm);
		if (!isEbc) {
			c1.init(Cipher.DECRYPT_MODE, deskey, new IvParameterSpec(iv));
		} else {
			c1.init(Cipher.DECRYPT_MODE, deskey);
		}

		return c1.doFinal(message);
	}

	/**
	 * 3des加密
	 * 
	 * @param value
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] TDESEncode(String value, String key, String chpAlgorithm, byte[] iv, boolean isEbc)
			throws Exception {
		byte[] keybyte = buildTDESKey(key);
		SecretKey deskey = new SecretKeySpec(keybyte, TDES_KEY_ALGORITHM);
		// Security.addProvider(new
		// org.bouncycastle.jce.provider.BouncyCastleProvider());//支持pkcs7
		Cipher cipher = Cipher.getInstance(chpAlgorithm);
		byte[] valuebyte = value.getBytes(ENCODING);

		if (!isEbc) {
			cipher.init(Cipher.ENCRYPT_MODE, deskey, new IvParameterSpec(iv));
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, deskey);
		}
		return cipher.doFinal(valuebyte);
	}

	/**
	 * 3des key生成
	 * 
	 * @param keyStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] buildTDESKey(String keyStr) throws UnsupportedEncodingException {
		byte[] key = new byte[24]; // 声明一个24位的字节数组，默认里面都是0
		byte[] temp = keyStr.getBytes(ENCODING); // 将字符串转成字节数组

		/*
		 * 执行数组拷贝 System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
		 */
		if (key.length > temp.length) {
			// 如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
			System.arraycopy(temp, 0, key, 0, temp.length);
		} else {
			// 如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
			System.arraycopy(temp, 0, key, 0, key.length);
		}
		return key;
	}

	/**
	 * 字符串 SHA 加密
	 * 
	 * @param strSourceText
	 * @return
	 */
	public static byte[] SHA(final String strText, final String strType) throws Exception {
		// 返回值
		byte[] strResult = new byte[0];

		// 是否是有效字符串
		if (strText != null && strText.length() > 0) {
			// SHA 加密开始
			// 创建加密对象 并傳入加密類型
			MessageDigest messageDigest = MessageDigest.getInstance(strType);
			// 传入要加密的字符串
			messageDigest.update(strText.getBytes());
			// 得到 byte 類型结果
			strResult = messageDigest.digest();
		}

		return strResult;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer(buf.length);
		String sTemp;
		for (int i = 0; i < buf.length; i++) {
			sTemp = Integer.toHexString(0xFF & buf[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

}