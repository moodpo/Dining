package com.moodpo.common.utils;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.moodpo.common.core.SysConfig;

/**
 * 邮件发送工具 使用Spring的邮件服务
 * 
 * @author xiaoxie
 * @date 2013-5-31 上午11:23:51
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.1
 */
public class MailUtils {

	private static final Logger logger = Logger.getLogger(MailUtils.class);
	
	/**
	 * 发送文本邮件
	 * @param subject 题目
	 * @param text 内容
	 * @param toMail 发送地址
	 */
	public static void SigleMailSend(String subject, String text, String toMail) {
		logger.info("SigleMailSend() start.");
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost(SysConfig.getConfig(SysConfig.MAIL_SERVER));
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toMail);
		mailMessage.setFrom(SysConfig.getConfig(SysConfig.MAIL_FROM));
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		
		senderImpl.setUsername(SysConfig.getConfig(SysConfig.MAIL_USER));
		senderImpl.setPassword(SysConfig.getConfig(SysConfig.MAIL_PASSWORD));
		
		// 邮件参数
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.timeout", "25000");
		prop.put("mail.smtp.port",SysConfig.getConfig(SysConfig.MAIL_PORT));

		senderImpl.setJavaMailProperties(prop);
		
		senderImpl.send(mailMessage);
		logger.info("SigleMailSend() end.");
	}
	
	
	/**
	 * 发送富文本邮件
	 * @param subject 题目
	 * @param text 内容
	 * @param toMail 发送地址
	 */
	public static void HTMLMailSend(String subject, String text, String toMail) throws Exception{
		logger.info("HTMLMailSend() start.");
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost(SysConfig.getConfig(SysConfig.MAIL_SERVER));
		
		MimeMessage mailMessage = senderImpl.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage); 
		
		messageHelper.setTo(toMail);
		messageHelper.setFrom(SysConfig.getConfig(SysConfig.MAIL_FROM));
        messageHelper.setSubject(subject);
        messageHelper.setText(text,true);
		
		senderImpl.setUsername(SysConfig.getConfig(SysConfig.MAIL_USER));
		senderImpl.setPassword(SysConfig.getConfig(SysConfig.MAIL_PASSWORD));
		
		// 邮件参数
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.timeout", "25000");
		prop.put("mail.smtp.port",SysConfig.getConfig(SysConfig.MAIL_PORT));

		senderImpl.setJavaMailProperties(prop);
		
		senderImpl.send(mailMessage);
		logger.info("HTMLMailSend() end.");
	}
	
	
	
	public static void main(String[] args) {
		try {
			MailUtils.HTMLMailSend("测试HTML邮件！", "<html><head></head><body><h1>Hello!!Spring Html Mail</h1></body></html>", "lijian@ultrapower.com.cn");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
