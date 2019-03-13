package com.gop.exchange.invocationHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import com.alibaba.fastjson.JSONObject;
import com.gop.exchange.adapter.Adapter;
import com.gop.exchange.adapter.ServiceAdapter;
import com.gop.exchange.annotation.Param;
import com.gop.exchange.annotation.UrlMapping;
import com.gop.exchange.dto.BaseDto;
import com.gop.exchange.exception.BaseException;
import com.gop.exchange.properties.Configure;

public class GopMarketFacadeInvocationHandler implements InvocationHandler {

	private static Object obj = new Object();
	private static Set<String> set = new HashSet<>();
	static {
		Method[] methods = obj.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			set.add(methods[i].getName());
		}
	}

	private final Adapter adapter = new ServiceAdapter();

	private Configure configure;

	public GopMarketFacadeInvocationHandler(Configure configure) {
		this.configure = configure;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (set.contains(method.getName())) {
			return obj.getClass().getMethod(method.getName()).invoke(method, args);
		}
		String url = configure.getHost();
		Map<String, String> map = new HashMap<String, String>();
		if (args == null || args.length == 0) {

		} else {
			if (args.length == 1 && (args[0] instanceof BaseDto)) {
				try {
					Map<String, Object> jsonmap = (Map<String, Object>) JSONObject.toJSON(args[0]);
					jsonmap.keySet().stream().forEach(new Consumer<String>() {

						@Override
						public void accept(String str) {
							if (null != jsonmap.get(str)) {
								map.put(str, jsonmap.get(str).toString());
							}

						}
					});

				} catch (Exception e) {
					throw BaseException.HTTP_ERROR;
				}
			} else {
				Annotation[][] anns = method.getParameterAnnotations();
				for (int i = 0; i < anns.length; i++) {
					if (null != args[i]) {
						map.put(((Param) anns[i][0]).value().toString(), args[i].toString());
					}

				}
			}

		}

		UrlMapping urlMapping = method.getAnnotation(UrlMapping.class);
		if (null == urlMapping) {
			throw BaseException.FINDE_ADAPTER_ERROR;
		}
		url = url + urlMapping.value();

		return adapter.handler(configure, map, method.getReturnType(), method.getGenericReturnType(), url);

	}

}
