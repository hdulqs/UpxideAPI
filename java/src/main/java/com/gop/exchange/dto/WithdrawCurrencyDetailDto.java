package com.gop.exchange.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.gop.exchange.enums.WithdrawCurrencyOrderStatus;

public class WithdrawCurrencyDetailDto extends BaseDto{

	private Integer brokerId;

	private String account;

	private String assetCode;

	private BigDecimal money;

	private BigDecimal pay;

	private BigDecimal fee;

	private String orderNo;

	private String payTransactionNo;

	private String acnumber;

	private String bank;

	private String name;

	private WithdrawCurrencyOrderStatus status;

	private String msg;

	private Date updateDate;

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getPay() {
		return pay;
	}

	public void setPay(BigDecimal pay) {
		this.pay = pay;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getOuterOrderNo() {
		return orderNo;
	}

	public void setOuterOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WithdrawCurrencyOrderStatus getStatus() {
		return status;
	}

	public void setStatus(WithdrawCurrencyOrderStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "ApiTransferOrderDetailDto [brokerId=" + brokerId + ", account=" + account + ", assetCode=" + assetCode
				+ ", money=" + money + ", pay=" + pay + ", fee=" + fee + ", outerOrderNo=" + orderNo + ", acnumber="
				+ acnumber + ", bank=" + bank + ", name=" + name + ", status=" + status + ", msg=" + msg
				+ ", updateDate=" + updateDate + "]";
	}

	public String getPayTransactionNo() {
		return payTransactionNo;
	}

	public void setPayTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}

}
