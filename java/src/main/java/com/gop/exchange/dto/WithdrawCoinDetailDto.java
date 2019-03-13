package com.gop.exchange.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.gop.exchange.enums.WithdrawCoinOrderStatus;

public class WithdrawCoinDetailDto extends BaseDto{

	private Date createDate;

	private String assetCode;

	private String transferOutAddress;

	private BigDecimal amount;

	private WithdrawCoinOrderStatus status;

	private String payTransactionNo;

	private String orderNo;

	public String getPayTransactionNo() {
		return payTransactionNo;
	}

	public void setPayTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getTransferOutAddress() {
		return transferOutAddress;
	}

	public void setTransferOutAddress(String transferOutAddress) {
		this.transferOutAddress = transferOutAddress;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public WithdrawCoinOrderStatus getStatus() {
		return status;
	}

	public void setStatus(WithdrawCoinOrderStatus status) {
		this.status = status;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	private BigDecimal fee;

	@Override
	public String toString() {
		return "WithdrawCoinDetailDto{" +
					 "createDate=" + createDate +
					 ", assetCode='" + assetCode + '\'' +
					 ", transferOutAddress='" + transferOutAddress + '\'' +
					 ", amount=" + amount +
					 ", status=" + status +
					 ", payTransactionNo='" + payTransactionNo + '\'' +
					 ", orderNo='" + orderNo + '\'' +
					 ", fee=" + fee +
					 '}';
	}
}