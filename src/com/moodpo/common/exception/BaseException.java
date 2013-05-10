package com.moodpo.common.exception;

public class BaseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException() {
		super();
	}
	
	public String errCode;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
}
