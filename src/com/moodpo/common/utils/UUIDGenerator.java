package com.moodpo.common.utils;

import java.util.UUID;

/**
 * uuid主键生成器
 * @author xiaoxie
 * @date 2013-4-26 上午11:06:31
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.1
 */
public class UUIDGenerator {
	
	public UUIDGenerator() {
		
	}
	
	/**
	 * 获取32位的uuid
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();
        // 去掉"-"符号  
		String temp = str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(UUIDGenerator.getUUID().length());
	}
	
}
