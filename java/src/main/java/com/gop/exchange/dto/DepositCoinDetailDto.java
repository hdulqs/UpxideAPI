package com.gop.exchange.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DepositCoinDetailDto extends BaseDto{

	private String coindAddress;

	private String message;

	private String payTransactionNo;

	private Date updateDate;

	private String assetCode;

	private BigDecimal amount;

	private BigDecimal fee;

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCoindAddress() {
		return coindAddress;
	}

	public void setCoindAddress(String coindAddress) {
		this.coindAddress = coindAddress;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPayTransactionNo() {
		return payTransactionNo;
	}

	public void setPayTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "DepositCoinDetailDto{" +
					 "coindAddress='" + coindAddress + '\'' +
					 ", message='" + message + '\'' +
					 ", payTransactionNo='" + payTransactionNo + '\'' +
					 ", updateDate=" + updateDate +
					 ", assetCode='" + assetCode + '\'' +
					 ", amount=" + amount +
					 ", fee=" + fee +
					 '}';
	}
}
