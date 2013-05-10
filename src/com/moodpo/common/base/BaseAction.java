package com.moodpo.common.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.moodpo.common.utils.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware , ServletRequestAware , ServletResponseAware{

	private static final long serialVersionUID = 1L;
	
	public Map<String,Object> session;
	
	public HttpServletRequest request;
	
	public HttpServletResponse response;
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	/**
	 * 与字段无关时使用的页面提示信息
	 */
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 分页信息
	 */
	private Pagination pagination;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
	private String validateCode;
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	/**
	 * 检查验证码
	 * @return
	 */
	public boolean checkValidateCode(){
		String code = this.getValidateCode();
		String kcode = (String) session.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kcode != null && kcode.equals(code)){
			return true;
		}
		return false;
	}
	
}
