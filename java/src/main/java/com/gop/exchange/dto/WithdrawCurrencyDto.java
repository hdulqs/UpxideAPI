package com.gop.exchange.dto;

import java.math.BigDecimal;

import com.gop.exchange.annotation.Param;

public class WithdrawCurrencyDto extends BaseDto{
	private String assetCode;
	private String externalOrderNo;
	private String identityCard;
	private String accountName;
	private BigDecimal payAmount;
	private String bankName;
	private String bankNo;

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getExternalOrderNo() {
		return externalOrderNo;
	}

	public void setExternalOrderNo(String externalOrderNo) {
		this.externalOrderNo = externalOrderNo;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}


	public static final class Builder {
		private String assetCode;
		private String externalOrderNo;
		private String identityCard;
		private String accountName;
		private BigDecimal payAmount;
		private String bankName;
		private String bankNo;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public Builder assetCode(String assetCode) {
			this.assetCode = assetCode;
			return this;
		}

		public Builder externalOrderNo(String externalOrderNo) {
			this.externalOrderNo = externalOrderNo;
			return this;
		}

		public Builder identityCard(String identityCard) {
			this.identityCard = identityCard;
			return this;
		}

		public Builder accountName(String accountName) {
			this.accountName = accountName;
			return this;
		}

		public Builder payAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
			return this;
		}

		public Builder bankName(String bankName) {
			this.bankName = bankName;
			return this;
		}

		public Builder bankNo(String bankNo) {
			this.bankNo = bankNo;
			return this;
		}

		public WithdrawCurrencyDto build() {
			WithdrawCurrencyDto transferCurrencyDto = new WithdrawCurrencyDto();
			transferCurrencyDto.setAssetCode(assetCode);
			transferCurrencyDto.setExternalOrderNo(externalOrderNo);
			transferCurrencyDto.setIdentityCard(identityCard);
			transferCurrencyDto.setAccountName(accountName);
			transferCurrencyDto.setPayAmount(payAmount);
			transferCurrencyDto.setBankName(bankName);
			transferCurrencyDto.setBankNo(bankNo);
			return transferCurrencyDto;
		}
	}
}
