package com.gop.exchange.enums;

public enum ServiceCodeEnums {
	HTTP_ERROR("100401", "连接错误"), FINDE_ADAPTER_ERROR("100104", "无效的接口"), CHECK_SIGN_ERROR("100403",
			"签名错误"), USER_NOT_FOUND("104102", "用户不存在"), CHECK_TIME_ERROR("105106", "时间戳已经失效"), SYS_ERR("100103",
					"服务繁忙"), INVALID_SYMBOL("102100", "无效的交易代码"), DUPLICATE_OUT_ORDER("102101",
							"重复的订单号"), SUCCESS("100200", "成功"), COIN_ASSERT_LESS("114100",
									"用户虚拟货币资产不足"), CURRENCY_ASSERT_LESS("114101", "用户人民币资产不足");
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ServiceCodeEnums(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public static ServiceCodeEnums getErrorCode(String code) {
		switch (code) {
		case "100401":
			return HTTP_ERROR;
		case "100104":
			return FINDE_ADAPTER_ERROR;
		case "100403":
			return CHECK_SIGN_ERROR;
		case "104102":
			return USER_NOT_FOUND;
		case "105106":
			return CHECK_TIME_ERROR;
		case "100103":
			return SYS_ERR;
		case "102100":
			return INVALID_SYMBOL;
		case "102101":
			return DUPLICATE_OUT_ORDER;
		case "100200":
			return SUCCESS;
		default:
			return null;
		}
	}

}
