package com.crm.utils;

import java.util.UUID;

/**
 * 文件上传
 * @author 梁翠翠
 *
 */
public class UploadUtil {
	/**
	 * 解决文件名重复问题，生成随机的文件名
	 * @param fileName
	 * @return
	 */
	public static String getUuidFileName(String fileName) {
		int idx = fileName.lastIndexOf(".");
		//获取后缀名
		String extions = fileName.substring(idx);
		//因为UUID生成的随机数是用-分隔的，将他去掉
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * 目录分离
	 * @param uuidFileName 文件名
	 * @return
	 */
	public static String getPath(String uuidFileName) {
		int code = uuidFileName.hashCode();
		//0xf是16进制数中的15
		int dir1 = code & 0xf;//一级目录，有8级
		//右移四位
		int code2 = code>>>4;
		int dir2 = code2 & 0xf;
		return "/"+dir1+"/"+dir2;
	}
}
