package com.moodpo.common.utils;

/**
 * 字符串工具
 * @author xiaoxie
 * @date 2013-5-2 上午09:21:37
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.1
 */
public class StringUtils {
	
	/**
	 * 生成N位随机字符串
	 * @param n
	 * @return
	 */
	public static String getRandomStr(int n){
		String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] chars = str.toCharArray();
		String result = "";
		for (int i = 0; i < n; i++) {
			int ran = (int) (Math.random() * str.length());
			result = result + chars[ran];
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(StringUtils.getRandomStr(10));
	}
}
