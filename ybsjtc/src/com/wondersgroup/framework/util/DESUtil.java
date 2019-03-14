package com.wondersgroup.framework.util;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加密解密程序.
 * 
 * <br>
 * 例子 <br>
 * String keydata = "12345678"; //密钥 <br>
 * String src = "987654321"; //待加密数据 <br>
 * System.out.println(encrypt(keydata, src)); //加密 <br>
 * System.out.println(decrypt(keydata, encrypt(keydata, src))); //解密
 * 
 * @author xiutong
 * 
 */
public class DESUtil {

	private final static String DES = "DES";
	private final static String CIPHER_ALGORITHM = "DES/ECB/NoPadding";

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		// 1.1 >>> 首先要创建一个密匙
		// DES算法要求有一个可信任的随机数源
		// SecureRandom sr = new SecureRandom();
		// 为我们选择的DES算法生成一个KeyGenerator对象
		// KeyGenerator kg = KeyGenerator.getInstance("DES");
		// kg.init(sr);
		// 生成密匙
		// SecretKey key = kg.generateKey();
		// 获取密匙数据
		String keydata = "www.wondersgroup.com";
		String src = "abc123"; // 待加密数据
		// 调用加密方法
		System.out.println(encrypt(keydata, src));
		// 调用解密方法
		System.out.println(decrypt(keydata, encrypt(keydata, src)));
	}

	/**
	 * DES加密函数.
	 * 
	 * @param keydata
	 *            10进制密码串
	 * @param src
	 *            要加密的字符串
	 * @return 加密后的16进制字符串
	 * 
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static String encrypt(String keydata, String src) throws InvalidKeyException, NoSuchAlgorithmException,
			IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeySpecException {

		if (StringUtil.isNullOrEmpty(keydata)) {
			keydata = "www.wondersgroup.com";
		}

		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(keydata.getBytes());
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, key, sr);
		// 现在，获取数据并加密
		byte data[] = src.getBytes();
		// 正式执行加密操作
		byte[] encryptedData = cipher.doFinal(data);

		// System.out.println("加密后===>" + CommUtil.byte2HexStr(encryptedData));
		return CommUtil.bytes2HexStr(encryptedData);
	}

	/**
	 * DES解密函数.
	 * 
	 * @param keydata
	 *            10进制密码串
	 * @param src
	 *            要解密的16进制字符串
	 * @return 解密后的字符串
	 * 
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static String decrypt(String keydata, String src) throws IllegalBlockSizeException, BadPaddingException,
			InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {

		if (StringUtil.isNullOrEmpty(keydata)) {
			keydata = "wondersgroup.com";
		}

		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(keydata.getBytes());
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, key, sr);
		// 正式执行解密操作
		byte decryptedData[] = cipher.doFinal(CommUtil.str2Bytes(src));
		// System.out.println("解密后===>" + new String(decryptedData));
		return new String(decryptedData);
	}

	/**
	 * 加密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 */
	public static byte[] encrypt(byte[] src, byte[] key) {
		SecureRandom sr = new SecureRandom();
		try {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			return cipher.doFinal(src);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] initKey() throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance(DES);
		kg.init(16);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 */
	public static byte[] decrypt(byte[] src, byte[] key) {
		SecureRandom sr = new SecureRandom();
		try {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			return cipher.doFinal(src);
		} catch (Exception e) {
		}
		return null;
	}
}
