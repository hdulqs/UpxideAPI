package com.gop.exchange.facade;

import com.gop.exchange.annotation.Param;
import com.gop.exchange.annotation.UrlMapping;
import com.gop.exchange.dto.Finance;
import com.gop.exchange.dto.MatchOrderDetailDto;
import com.gop.exchange.dto.MatchOrderDto;
import com.gop.exchange.dto.Pair;

import java.util.List;

/**
 * 所有异常均为BaseException 派生，如果发生异常请提取errorCode，进行区分
 *
 * @author wangyang
 */
public interface GopMarketExchangeFacade {

	/**
	 * 查询用户资产
	 */
	@UrlMapping("/api/asset")
	public List<Finance> queryFinance();
    /*
     * 挂单
     */
	@UrlMapping("/api/matchOrder")
	public void matchOrder(MatchOrderDto matchOrderDto);

	/**
	 * 查询交易详情
	 *
	 * @param outorderNo
	 *            外部订单号
	 */
	@UrlMapping("/api/orderquery")
	public MatchOrderDetailDto queryMatchOrder(@Param("outTradeNo") String outorderNo);

	/**
    * 查询挂单进行中的接口：ps：最多返回200个。
    * @param symbol 交易代码
    * @return
    */
	@UrlMapping("/api/matchOrder/process")
	public List<MatchOrderDetailDto> queryOrderProcess(@Param("symbol") String symbol);

	/**
	 * 取消订单
	 *
	 * @param outOrderNo
	 *            外部订单号
	 */
	@UrlMapping("/api/cancel")
	public void  cancelMatchOrder(@Param("outTradeNo") String outOrderNo);

	@UrlMapping("/api/pairList")
	public List<Pair>  pairList();

}


