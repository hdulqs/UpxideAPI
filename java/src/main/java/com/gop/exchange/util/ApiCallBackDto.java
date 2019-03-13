package com.gop.exchange.util;

public class ApiCallBackDto<T> {
	private String userNo;
	private String signature;
	private T data;
	private String code;
	private String nonceStr;
	private Integer timestamp;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ApiCallBack [userNo=" + userNo + ", signature=" + signature + ", data=" + data + ", code=" + code
				+ ", nonceStr=" + nonceStr + ", timestamp=" + timestamp + "]";
	}

}
