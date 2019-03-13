package com.gop.exchange.exception;

public class RemotServerError extends BaseException {
	public static final RemotServerError REMOT_SERVER_PARSE_ERROR = new RemotServerError("PARSEERROR", "远程数据解析错误");

	public RemotServerError(String errorCode, String errDesc) {
		super(errorCode, errDesc);
	}

	

}
