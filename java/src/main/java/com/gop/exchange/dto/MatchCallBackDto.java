package com.gop.exchange.dto;

public class MatchCallBackDto extends BaseDto{
	private String payTransactionNo;
	private String orderNo;

	public String getTransactionNo() {
		return payTransactionNo;
	}

	public void setTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "MatchCallBackDto [transactionNo=" + payTransactionNo + ", orderNo=" + orderNo + "]";
	}

}
