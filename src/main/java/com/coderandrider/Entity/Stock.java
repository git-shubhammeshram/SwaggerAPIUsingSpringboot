package com.coderandrider.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	private String stockName;
	private Double stockPrice;

	public Stock() {
	}

	public Stock(String stockName, Double stockPrice) {
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public String toString() {
		return "Stock{" + "stockId=" + stockId + ", stockName='" + stockName + '\'' + ", stockPrice=" + stockPrice + '}';
	}
}
