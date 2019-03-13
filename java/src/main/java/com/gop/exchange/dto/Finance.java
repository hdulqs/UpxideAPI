package com.gop.exchange.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Finance {
	private Integer id;

	private Integer uid;

	private Integer brokerId;

	private String accountNo;

	private String accountKind;

	private String assetCode;

	private BigDecimal amountAvailable;

	private BigDecimal amountLock;

	private BigDecimal amountLoan;

	private Date updateDate;

	private Integer version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountKind() {
		return accountKind;
	}

	public void setAccountKind(String accountKind) {
		this.accountKind = accountKind;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public BigDecimal getAmountAvailable() {
		return amountAvailable;
	}

	public void setAmountAvailable(BigDecimal amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public BigDecimal getAmountLock() {
		return amountLock;
	}

	public void setAmountLock(BigDecimal amountLock) {
		this.amountLock = amountLock;
	}

	public BigDecimal getAmountLoan() {
		return amountLoan;
	}

	public void setAmountLoan(BigDecimal amountLoan) {
		this.amountLoan = amountLoan;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
