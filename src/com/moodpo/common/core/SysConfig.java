package com.moodpo.common.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 系统相关配置类
 * 
 * @author xiaoxie
 * @date 2013-4-23 下午04:45:45
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.1
 */
public class SysConfig {

	private static Logger logger = Logger.getLogger(SysConfig.class);

	/**
	 * 系统邮箱
	 */
	public static String SYSTEM_EMAIL = "SystemEmail";
	
	/**
	 * 邮件服务器 smtp
	 */
	public static String MAIL_SERVER = "MailServer";
	
	/**
	 * 邮件服务端口
	 */
	public static String MAIL_PORT = "MailPort";
	
	/**
	 * 邮箱用户名
	 */
	public static String MAIL_USER = "MailUser";
	
	/**
	 * 邮箱密码
	 */
	public static String MAIL_PASSWORD = "MailPassword";

	private static Properties SYSTEM_CONFIG = new Properties();

	public static String getConfig(String key) {

		String result = SYSTEM_CONFIG.getProperty(key.trim());
		try {
			result = result.trim();
			result = new String(result.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("System config file get error ! Filed : " + key, e);
		} catch (Exception e) {
			logger.error("System config file get error ! Filed : " + key, e);
		}
		return result;
	}

	public static void initConfig(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			SYSTEM_CONFIG.load(fis);
		} catch (Exception e) {
			logger.error("System config file init fail !", e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
