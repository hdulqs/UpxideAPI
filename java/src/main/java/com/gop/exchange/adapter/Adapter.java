package com.gop.exchange.adapter;

import java.lang.reflect.Type;
import java.util.Map;

import com.gop.exchange.properties.Configure;

public interface Adapter {

	public Object handler(Configure configure, Map args,Class<?> classs,Type returnType,String url);
}
