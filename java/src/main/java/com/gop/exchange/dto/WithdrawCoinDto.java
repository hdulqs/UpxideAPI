package com.gop.exchange.dto;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class WithdrawCoinDto extends BaseDto {
	@JSONField(name = "assetCode")
	private final String assetCode;
	@JSONField(name = "toAddress")
	private final String toAddress;
	@JSONField(name = "amount")
	private final BigDecimal amount;
	@JSONField(name = "fee")
	private final BigDecimal fee;
	@JSONField(name = "message")
	private final String message;
	@JSONField(name = "orderNo")
	private final String orderNo;

	private WithdrawCoinDto(String assetCode, String toAddress, BigDecimal amount, BigDecimal fee, String message,
			String orderNo) {
		super();
		this.assetCode = assetCode;
		this.toAddress = toAddress;
		this.amount = amount;
		this.fee = fee;
		this.message = message;
		this.orderNo = orderNo;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public String getToAddress() {
		return toAddress;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public String getMessage() {
		return message;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public static class Builder {
		private String assetCode;
		private String toAddress;
		private BigDecimal amount;
		private BigDecimal fee;
		private String message;
		private String orderNo;

		public static Builder newBuild() {
			return new Builder();
		}

		public Builder MatchOrderAssetCode(String assetCode) {
			this.assetCode = assetCode;
			return this;
		}

		public Builder MatchOrdertoAddress(String toAddress) {
			this.toAddress = toAddress;
			return this;
		}

		public Builder MatchOrderAmount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder MatchOrderFee(BigDecimal fee) {
			this.fee = fee;
			return this;
		}

		public Builder MatchOrdermessage(String message) {
			this.message = message;
			return this;
		}

		public Builder MatchOrderorderNo(String orderNo) {
			this.orderNo = orderNo;
			return this;
		}

		public WithdrawCoinDto build() {
			return new WithdrawCoinDto(this.assetCode, this.toAddress, this.amount, this.fee, this.message, this.orderNo);
		}
	}

}
