package com.gop.exchange.dto;

import com.gop.exchange.enums.TradeCoinFlag;
import com.gop.exchange.enums.TradeCoinType;

public class MatchOrderDto extends BaseDto {
	// 订单号，唯一
	private String outOrderNo;
	// 交易代码
	private String symbol;
	// tradeCoinFlag:fixed只能挂限价单
	private TradeCoinFlag tradeCoinFlag;
	// tradeCoinType：买卖单
	private TradeCoinType tradeCoinType;
	// price:价格
	private String price;
	// amount：数量
	private String amount;
	// 废弃
	private String market;

	public String getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public TradeCoinFlag getTradeCoinFlag() {
		return tradeCoinFlag;
	}

	public void setTradeCoinFlag(TradeCoinFlag tradeCoinFlag) {
		this.tradeCoinFlag = tradeCoinFlag;
	}

	public TradeCoinType getTradeCoinType() {
		return tradeCoinType;
	}

	public void setTradeCoinType(TradeCoinType tradeCoinType) {
		this.tradeCoinType = tradeCoinType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public static final class MatchOrderDtoBuilder {
		private String outOrderNo;
		private String symbol;
		private TradeCoinFlag tradeCoinFlag;
		private TradeCoinType tradeCoinType;
		private String price;
		private String amount;
		private String market;

		private MatchOrderDtoBuilder() {
		}

		public static MatchOrderDtoBuilder newBuilder() {
			return new MatchOrderDtoBuilder();
		}

		public MatchOrderDtoBuilder outOrderNo(String outOrderNo) {
			this.outOrderNo = outOrderNo;
			return this;
		}

		public MatchOrderDtoBuilder symbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public MatchOrderDtoBuilder tradeCoinFlag(TradeCoinFlag tradeCoinFlag) {
			this.tradeCoinFlag = tradeCoinFlag;
			return this;
		}

		public MatchOrderDtoBuilder tradeCoinType(TradeCoinType tradeCoinType) {
			this.tradeCoinType = tradeCoinType;
			return this;
		}

		public MatchOrderDtoBuilder price(String price) {
			this.price = price;
			return this;
		}

		public MatchOrderDtoBuilder amount(String amount) {
			this.amount = amount;
			return this;
		}

		public MatchOrderDtoBuilder market(String market) {
			this.market = market;
			return this;
		}

		public MatchOrderDto build() {
			MatchOrderDto matchOrderDto = new MatchOrderDto();
			matchOrderDto.setOutOrderNo(outOrderNo);
			matchOrderDto.setSymbol(symbol);
			matchOrderDto.setTradeCoinFlag(tradeCoinFlag);
			matchOrderDto.setTradeCoinType(tradeCoinType);
			matchOrderDto.setPrice(price);
			matchOrderDto.setAmount(amount);
			matchOrderDto.setMarket(market);
			return matchOrderDto;
		}
	}

	@Override
	public String toString() {
		return "MatchOrderDto{" + "outOrderNo='" + outOrderNo + '\'' + ", symbol='" + symbol + '\'' + ", tradeCoinFlag="
				+ tradeCoinFlag + ", tradeCoinType=" + tradeCoinType + ", price='" + price + '\'' + ", amount='"
				+ amount + '\'' + ", market='" + market + '\'' + '}';
	}
}
