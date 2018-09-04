package com.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.sun.xml.internal.ws.encoding.xml.XMLMessage.MessageDataSource;

/**
 * 加密
 * @author 梁翠翠
 *
 */
public class MD5Util {
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (Exception e) {
			throw new RuntimeException("没有这个算法");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		//如果生成数字未满32位，补0
		for(int i=0;i<32-md5code.length();i++) {
			md5code = "0"+md5code;
		}
		return md5code;
	}
	public static void main(String[] args) {
		System.out.println(md5("123"));
	}
}
