package com.ehualu.rise.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 密码加密
 * @author Administrator
 *
 */
public class SecurityUtil {

	
	/**
	 * 密码单独加密
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public static String md5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes("UTF-8"));
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	/**
	 * 用户和密码双加密
	 * @param username
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String username,String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(username.getBytes());
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	/**
	 * 为数据库中的机密数据解密
	 * @param txt
	 * @param secretKey
	 * @return
	 */
	public static String decrypt(String txt,String secretKey){
		try {
			//获取解密秘钥
			byte[] raw = Hex.decodeHex((secretKey).toCharArray());
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			//获取解密对象
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			//对加密信息解密
			byte[] decrypted = cipher.doFinal(Hex.decodeHex((txt).toCharArray()));
			String datatxt = new String(decrypted);
			
			return datatxt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args){
		try {
			String hphm = "辽DR6368";
			
//			String hphmStr=new String("辽DR6368".getBytes(),"GBK");
			String str = SecurityUtil.md5(hphm);
			System.out.println("str="+str);
			System.out.println("Charset="+Charset.defaultCharset());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
