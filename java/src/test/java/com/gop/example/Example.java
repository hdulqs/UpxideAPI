package com.gop.example;

import com.gop.exchange.facade.GopMarketExchangeFacade;
import com.gop.exchange.factory.FacadeBeanFactory;
import com.gop.exchange.properties.Configure;

public class Example {
	public static void main(String[] args) {

		GopMarketExchangeFacade gopMarketExchangeFacade = FacadeBeanFactory.FacadeBeanFactoryInstance(new Configure() {

			@Override
			public String getHost() {
				return "https://market.upxide.com/exchangeApi";
			}

			@Override
			public String getBusinessNo() {

				return "";
			}

			@Override
			public String getApiSecret() {
				return "";
			}

		}).getMarketFacade();



//	   gopMarketExchangeFacade.matchOrder(matchOrderDto);
	    System.out.println(gopMarketExchangeFacade.queryFinance());
//        System.out.println(gopMarketExchangeFacade);
//		System.out.println(gopMarketExchangeFacade.pairList());

	}

}
