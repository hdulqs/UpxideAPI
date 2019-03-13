package com.gop.exchange.factory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.gop.exchange.adapter.Adapter;
import com.gop.exchange.annotation.AdapterHandler;
import com.gop.exchange.exception.BaseException;
import com.gop.exchange.util.ClassUtil;
import com.gop.exchange.util.Preconditions;

public class AdapterFactory {

	private final String ADAPTER_PACKAGE = "com.gop.exchange.adapter";
	private String adapterPackage = ADAPTER_PACKAGE;
	private static AdapterFactory adapterFactory;
	private ImmutableMap<String, Adapter> objectFactory;

	public String getAdapterPackage() {
		return adapterPackage;
	}

	public void setAdapterPackage(String adapterPackage) {
		this.adapterPackage = adapterPackage;
	}

	public static Adapter getAdapter(Method method) {
		if (null == adapterFactory) {
			init();
		}
		Adapter adapter = adapterFactory.getAdapterByName(method.getName());
		return adapter;

	}

	public static Adapter getAdapter(String methodName) {
		if (null == adapterFactory) {
			init();
		}
		Adapter adapter = adapterFactory.getAdapterByName(methodName);
		
		return adapter;

	}

	private AdapterFactory() {

	}

	private synchronized static void init() {
		if (null != adapterFactory)
			return;
		adapterFactory = new AdapterFactory();
		Set<Class<?>> clas = ClassUtil.getClasses("com.gop.exchange.adapter", AdapterHandler.class);
		Iterator<Class<?>> iterator = clas.iterator();
		Map<String, Adapter> map = new HashMap<>();
		while (iterator.hasNext()) {
			Class<?> cla = iterator.next();
			if (cla.getAnnotation(AdapterHandler.class) != null) {
				String value = cla.getAnnotation(AdapterHandler.class).value();
				Adapter adapter = null;
				try {
					adapter = (Adapter) cla.newInstance();
				} catch (Exception e) {
					throw BaseException.FINDE_ADAPTER_ERROR;
				}
				map.put(value, adapter);
			}
		}
		adapterFactory.objectFactory = ImmutableMap.copyOf(map);
	}

	public Adapter getAdapterByName(String name) {
		return objectFactory.get(name);
	}
}
