package com.xgit.iot.infra.exception;

import com.xgit.iot.infra.ErrorCode;

/**
 * 异常处理
 *
 */
public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 2368925481129834020L;

	/**
	 * 异常码
	 */
	private int code;

	private Object value;

	public BusinessException(String message){
		super(message);
	}

	public BusinessException(int code, String message){
		super(message);
		this.code=code;
	}

	public BusinessException(int code, String message, Object value){
		this(code,message);
		this.value=value;
	}

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getDesc());
		this.code=errorCode.getCode();
	}
	public BusinessException(ErrorCode errorCode, Object value) {
		this(errorCode);
		this.value=value;
	}
	public BusinessException(ErrorCode errorCode, Object value, Throwable cause) {
		super(errorCode.getDesc(),cause);
		this.code=errorCode.getCode();
		this.value=value;
	}

	public int getCode() {
		return code;
	}

	public Object getValue() {
		return value;
	}
}
