package com.gop.exchange.adapter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gop.exchange.dto.ApiResponseDto;
import com.gop.exchange.enums.ServiceCodeEnums;
import com.gop.exchange.exception.BaseException;
import com.gop.exchange.properties.Configure;
import com.gop.exchange.util.HttpUtil;
import com.gop.exchange.util.SignUtil;

@com.gop.exchange.annotation.AdapterHandler("buyFixed")

public class ServiceAdapter implements Adapter {

	@Override
	public Object handler(Configure configure, Map map, Class<?> classs, Type type, String url) {

		String key = configure.getApiSecret();

		String businessNo = configure.getBusinessNo();

		String nonceStr = SignUtil.defaultGenerateNonceStr();

		long timestamp = (long) (System.currentTimeMillis() / 1000);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("businessNo", businessNo);
		jsonObject.put("nonceStr", nonceStr);
		jsonObject.put("timestamp", timestamp);
		jsonObject.put("data", map);
		String sign = SignUtil.generateSign(map, timestamp, nonceStr, key);

		jsonObject.put("sign", sign);
		ApiResponseDto apiResponse = null;

		String responseString;

		try {
			responseString = HttpUtil.post(url, jsonObject.toJSONString());
			 System.out.println(responseString);
		} catch (Exception e) {
			e.printStackTrace();
			throw BaseException.HTTP_ERROR;
		}
		apiResponse = JSON.parseObject(responseString, ApiResponseDto.class);
		if (apiResponse == null) {
			throw BaseException.HTTP_ERROR;
		}

		ServiceCodeEnums serviceCodeEnums = ServiceCodeEnums.getErrorCode(apiResponse.getCode());
		if (null == serviceCodeEnums) {
			throw new BaseException(apiResponse.getCode(), apiResponse.getMsg());
		}
		if (!serviceCodeEnums.equals(ServiceCodeEnums.SUCCESS)) {
			throw new BaseException(serviceCodeEnums.getCode(), serviceCodeEnums.getMessage());
		}

		try {
			if (classs.isArray()) {
				if (type instanceof ParameterizedType) { // 判断获取的类型是否是参数类型
					// 禁止返回map
					Type[] typesto = ((ParameterizedType) type).getActualTypeArguments();// 强制转型为带参数的泛型类型，
					return JSON.parseArray(apiResponse.getData(), Class.forName(typesto[0].getTypeName()));
				}
			}

			return JSONObject.parseObject(apiResponse.getData(), classs);

		} catch (Exception e) {

			throw BaseException.HTTP_ERROR;
		}

	}

}
