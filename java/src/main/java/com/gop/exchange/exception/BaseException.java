package com.gop.exchange.exception;

public class BaseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8740690446370151742L;

	private String errorCode;

	private String errDesc;

	public static final BaseException HTTP_ERROR = new BaseException("100401", "连接错误");

	public static final BaseException FINDE_ADAPTER_ERROR = new BaseException("100402", "没有找到接口适配器");

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public BaseException(String errorCode, String errDesc) {
		super();
		this.errorCode = errorCode;
		this.errDesc = errDesc;
	}

	@Override
	public String getMessage() {

		return "errorCode:" + getErrorCode() + "_ errorCodeDesc:" + getErrDesc();
	}

	@Override
	public synchronized Throwable fillInStackTrace() {

		return null;
	}

}
