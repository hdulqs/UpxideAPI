package com.gop.exchange.callback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.gop.exchange.dto.ApiCallBackDto;
import com.gop.exchange.dto.WithdrawCoinDetailDto;
import com.gop.exchange.enums.ServiceCodeEnums;
import com.gop.exchange.exception.BaseException;
import com.gop.exchange.util.SignUtil;

/**
 * @author wangyang 回调的结果和通过api查询的dto一样
 */

public class CallBackUtil {
	@SuppressWarnings("unchecked")
	public static <T> T handlerMatchBack(String jsonString, String businessNo, String apiSecret, Class<T> t) {
		ApiCallBackDto<JSONObject> apiCallBack = null;
		try {
			apiCallBack = JSON.parseObject(jsonString, ApiCallBackDto.class);
		} catch (Exception e) {
			throw new BaseException(ServiceCodeEnums.CHECK_SIGN_ERROR.getCode(),
					"远程返回格式无效，非json");
		}
		if (null == apiCallBack) {
			throw new BaseException(ServiceCodeEnums.CHECK_SIGN_ERROR.getCode(),
					"远程返回值为空");
		}
		if (!SignUtil.checkSign(jsonString, apiSecret)) {
			throw new BaseException(ServiceCodeEnums.CHECK_SIGN_ERROR.getCode(),
					ServiceCodeEnums.CHECK_SIGN_ERROR.getMessage());
		}
		if (!businessNo.equalsIgnoreCase(apiCallBack.getUserNo())) {
			throw new BaseException(ServiceCodeEnums.USER_NOT_FOUND.getCode(),
					ServiceCodeEnums.USER_NOT_FOUND.getMessage());
		}
		String code = apiCallBack.getCode();
		if (Strings.isNullOrEmpty(code)) {
			throw new BaseException(ServiceCodeEnums.CHECK_SIGN_ERROR.getCode(),
					"返回码无效");
		}
		if (!ServiceCodeEnums.SUCCESS.equals(ServiceCodeEnums.getErrorCode(code))) {
			ServiceCodeEnums serviceCodeEnums = Optional.fromNullable(ServiceCodeEnums.getErrorCode(code))
					.or(ServiceCodeEnums.CHECK_SIGN_ERROR);
			throw new BaseException(serviceCodeEnums.getCode(), serviceCodeEnums.getMessage());
		}

		apiCallBack.getData();
		return JSONObject.toJavaObject(apiCallBack.getData(), t);

	}

}
