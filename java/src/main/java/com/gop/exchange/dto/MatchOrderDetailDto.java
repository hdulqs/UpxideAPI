package com.gop.exchange.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.gop.exchange.enums.TradeCoinFlag;
import com.gop.exchange.enums.TradeCoinStatus;
import com.gop.exchange.enums.TradeCoinType;

public class MatchOrderDetailDto extends BaseDto{
	private Date createTime;

	private BigDecimal tradedNumber;

	private BigDecimal numberOver;
	// 交易号
	private String orderNo;
	private String payTransactionNo;
	// 下单类型
	private TradeCoinType tradeCoinType;
	// 下单种类
	private TradeCoinFlag tradeCoinFlag;
	// 交易对
	private String symbol;
	// 下单价格
	private BigDecimal price;
	// 下单数量
	private BigDecimal number;
	// 成交金额
	private BigDecimal matchedMoney;
	private BigDecimal moneyOver;
	private BigDecimal money;
   
	// 交易状态
	private TradeCoinStatus tradeCoinStatus;

	
	@Override
	public String toString() {
		return "MatchOrderDetailDto [createTime=" + createTime + ", tradedNumber=" + tradedNumber + ", numberOver="
				+ numberOver + ", orderNo=" + orderNo + ", payTransactionNo=" + payTransactionNo + ", tradeCoinType="
				+ tradeCoinType + ", tradeCoinFlag=" + tradeCoinFlag + ", symbol=" + symbol + ", price=" + price
				+ ", number=" + number + ", matchedMoney=" + matchedMoney + ", moneyOver=" + moneyOver + ", money="
				+ money + ", tradeCoinStatus=" + tradeCoinStatus + "]";
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTradedNumber() {
		return tradedNumber;
	}

	public void setTradedNumber(BigDecimal tradedNumber) {
		this.tradedNumber = tradedNumber;
	}

	public BigDecimal getNumberOver() {
		return numberOver;
	}

	public void setNumberOver(BigDecimal numberOver) {
		this.numberOver = numberOver;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public TradeCoinType getTradeCoinType() {
		return tradeCoinType;
	}

	public void setTradeCoinType(TradeCoinType tradeCoinType) {
		this.tradeCoinType = tradeCoinType;
	}

	public TradeCoinFlag getTradeCoinFlag() {
		return tradeCoinFlag;
	}

	public void setTradeCoinFlag(TradeCoinFlag tradeCoinFlag) {
		this.tradeCoinFlag = tradeCoinFlag;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public BigDecimal getMatchedMoney() {
		return matchedMoney;
	}

	public void setMatchedMoney(BigDecimal matchedMoney) {
		this.matchedMoney = matchedMoney;
	}

	public BigDecimal getMoneyOver() {
		return moneyOver;
	}

	public void setMoneyOver(BigDecimal moneyOver) {
		this.moneyOver = moneyOver;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public TradeCoinStatus getTradeCoinStatus() {
		return tradeCoinStatus;
	}

	public void setTradeCoinStatus(TradeCoinStatus tradeCoinStatus) {
		this.tradeCoinStatus = tradeCoinStatus;
	}

	public String getPayTransactionNo() {
		return payTransactionNo;
	}

	public void setPayTransactionNo(String payTransactionNo) {
		this.payTransactionNo = payTransactionNo;
	}


	public static final class MatchOrderDetailDtoBuilder {
		private Date createTime;
		private BigDecimal tradedNumber;
		private BigDecimal numberOver;
		// 交易号
    private String orderNo;
		private String payTransactionNo;
		// 下单类型
    private TradeCoinType tradeCoinType;
		// 下单种类
    private TradeCoinFlag tradeCoinFlag;
		// 交易对
    private String symbol;
		// 下单价格
    private BigDecimal price;
		// 下单数量
    private BigDecimal number;
		// 成交金额
    private BigDecimal matchedMoney;
		private BigDecimal moneyOver;
		private BigDecimal money;
		// 交易状态
    private TradeCoinStatus tradeCoinStatus;

		private MatchOrderDetailDtoBuilder() {
		}

		public static MatchOrderDetailDtoBuilder newBuilder() {
			return new MatchOrderDetailDtoBuilder();
		}

		public MatchOrderDetailDtoBuilder createTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		public MatchOrderDetailDtoBuilder tradedNumber(BigDecimal tradedNumber) {
			this.tradedNumber = tradedNumber;
			return this;
		}

		public MatchOrderDetailDtoBuilder numberOver(BigDecimal numberOver) {
			this.numberOver = numberOver;
			return this;
		}

		public MatchOrderDetailDtoBuilder orderNo(String orderNo) {
			this.orderNo = orderNo;
			return this;
		}

		public MatchOrderDetailDtoBuilder payTransactionNo(String payTransactionNo) {
			this.payTransactionNo = payTransactionNo;
			return this;
		}

		public MatchOrderDetailDtoBuilder tradeCoinType(TradeCoinType tradeCoinType) {
			this.tradeCoinType = tradeCoinType;
			return this;
		}

		public MatchOrderDetailDtoBuilder tradeCoinFlag(TradeCoinFlag tradeCoinFlag) {
			this.tradeCoinFlag = tradeCoinFlag;
			return this;
		}

		public MatchOrderDetailDtoBuilder symbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public MatchOrderDetailDtoBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}

		public MatchOrderDetailDtoBuilder number(BigDecimal number) {
			this.number = number;
			return this;
		}

		public MatchOrderDetailDtoBuilder matchedMoney(BigDecimal matchedMoney) {
			this.matchedMoney = matchedMoney;
			return this;
		}

		public MatchOrderDetailDtoBuilder moneyOver(BigDecimal moneyOver) {
			this.moneyOver = moneyOver;
			return this;
		}

		public MatchOrderDetailDtoBuilder money(BigDecimal money) {
			this.money = money;
			return this;
		}

		public MatchOrderDetailDtoBuilder tradeCoinStatus(TradeCoinStatus tradeCoinStatus) {
			this.tradeCoinStatus = tradeCoinStatus;
			return this;
		}

		public MatchOrderDetailDto build() {
			MatchOrderDetailDto matchOrderDetailDto = new MatchOrderDetailDto();
			matchOrderDetailDto.setCreateTime(createTime);
			matchOrderDetailDto.setTradedNumber(tradedNumber);
			matchOrderDetailDto.setNumberOver(numberOver);
			matchOrderDetailDto.setOrderNo(orderNo);
			matchOrderDetailDto.setPayTransactionNo(payTransactionNo);
			matchOrderDetailDto.setTradeCoinType(tradeCoinType);
			matchOrderDetailDto.setTradeCoinFlag(tradeCoinFlag);
			matchOrderDetailDto.setSymbol(symbol);
			matchOrderDetailDto.setPrice(price);
			matchOrderDetailDto.setNumber(number);
			matchOrderDetailDto.setMatchedMoney(matchedMoney);
			matchOrderDetailDto.setMoneyOver(moneyOver);
			matchOrderDetailDto.setMoney(money);
			matchOrderDetailDto.setTradeCoinStatus(tradeCoinStatus);
			return matchOrderDetailDto;
		}
	}


}
