package com.gop.exchange.util;

public class Preconditions {

	public static <T> T checkNotNull(T obj, RuntimeException excption) throws RuntimeException {
		if (obj == null) {
			throw excption;
		}
		return obj;
	}
	


}
