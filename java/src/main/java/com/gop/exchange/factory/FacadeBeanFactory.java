package com.gop.exchange.factory;

import com.google.common.reflect.Reflection;
import com.gop.exchange.facade.GopMarketExchangeFacade;
import com.gop.exchange.invocationHandler.GopMarketFacadeInvocationHandler;
import com.gop.exchange.properties.Configure;

public class FacadeBeanFactory {

	private Configure configure;

	private GopMarketExchangeFacade gopMarketExchangeFacade;

	private FacadeBeanFactory(Configure configure) {
		this.configure = configure;
	}

	public static FacadeBeanFactory FacadeBeanFactoryInstance(Configure configure) {
		return new FacadeBeanFactory(configure);
	}

	public synchronized GopMarketExchangeFacade  getMarketFacade() {
		if (gopMarketExchangeFacade == null) {
			gopMarketExchangeFacade = makeFacade();
		}
		return gopMarketExchangeFacade;
	}

	private GopMarketExchangeFacade makeFacade() {
		
		return Reflection.newProxy(GopMarketExchangeFacade.class, new GopMarketFacadeInvocationHandler(configure));
	}
}
