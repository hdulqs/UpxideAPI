package com.gop.exchange.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.javatuples.Pair;

import com.alibaba.fastjson.JSONObject;
import com.gop.exchange.exception.BaseException;

public class AsyncHttpUtil {

	private static CloseableHttpAsyncClient httpclient;

	private static final int AWAIT_TIME = 10000;
	private static final TimeUnit TIMR_UNIT = TimeUnit.MILLISECONDS;

	public static void asyncPost(String url, String str, FutureCallback<HttpResponse> callBack)
			throws UnsupportedEncodingException {

		CloseableHttpAsyncClient httpclient = getHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("Accept-Language", "zh-CN");
		httpPost.setEntity(new StringEntity(str, "UTF-8"));
		httpclient.execute(httpPost, callBack);

	}

	public static String syncPost(String url, String str) throws UnsupportedEncodingException {

		CloseableHttpAsyncClient httpclient = getHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(str, "UTF-8"));
		httpPost.setHeader("Content-Type", "application/json");
		DefautFutureCallBack futureCallback = new DefautFutureCallBack();
		httpclient.execute(httpPost, futureCallback);
		return futureCallback.await().get().toString();
	}

	public static String syncGet(String url) {

		CloseableHttpAsyncClient httpclient = getHttpClient();
		HttpGet httpGet = new HttpGet(url);
		DefautFutureCallBack futureCallback = new DefautFutureCallBack();
		Future<HttpResponse> feture = httpclient.execute(httpGet, futureCallback);
		return futureCallback.await().get().toString();
	}

	public static void asyncpostJson(String url, JSONObject json, FutureCallback<HttpResponse> callBack)
			throws UnsupportedEncodingException {

	}

	private static class DefautFutureCallBack implements FutureCallback<HttpResponse> {
		private Pair<Boolean, Object> pair;
		private CountDownLatch latch = new CountDownLatch(1);

		@Override
		public void cancelled() {

			latch.countDown();
		}

		@Override
		public void completed(HttpResponse response) {
			try {
				String result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
				pair = new Pair<Boolean, Object>(true, result);
				latch.countDown();
			} catch (Exception e) {
				pair.setAt1(e);
			}
		}

		@Override
		public void failed(Exception expection) {
			expection.printStackTrace();

			pair = new Pair<Boolean, Object>(false, BaseException.HTTP_ERROR);
			latch.countDown();
		}

		public DefautFutureCallBack await() {
			try {
				latch.await(AWAIT_TIME, TIMR_UNIT);
			} catch (InterruptedException e) {
				pair = new Pair<Boolean, Object>(false, BaseException.HTTP_ERROR);
			}
			return this;
		}

		public Object get() throws BaseException {

			if (pair.getValue0().equals(true))
				return pair.getValue1();
			else
				throw (BaseException) pair.getValue1();
		}

	}

	private static CloseableHttpAsyncClient getHttpClient() {
		if (null == httpclient || !httpclient.isRunning()) {
			init();
		}
		return httpclient;
	}

	private static void init() {
		if (null == httpclient) {
			httpclient = HttpAsyncClients.createMinimal();
			httpclient.start();

			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					try {
						if (httpclient.isRunning()) {
							httpclient.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}));
		}
	}

	

}
