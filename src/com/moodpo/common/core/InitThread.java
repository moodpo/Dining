package com.moodpo.common.core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * 系统初始化类
 * 
 * @author xiaoxie
 * @date 2013-4-23 下午04:46:14
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.1
 */
public class InitThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(InitThread.class);
	
	public void init() throws ServletException {

		String path = System.getProperty("webapp.root")
				+ "WEB-INF/classes/config/config.properties";

		logger.info("======================================");
		logger.info("系统配置文件路径 " + path);
		logger.info("======================================");
		
		// 初始化系统配置
		SysConfig.initConfig(path);

	}

}
