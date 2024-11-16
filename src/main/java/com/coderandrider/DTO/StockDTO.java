package com.coderandrider.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class StockDTO {

	private Long stockId;
	private String stockName;
	private Double stockPrice;

	public StockDTO() {
	}

	public StockDTO(Long stockId, String stockName, Double stockPrice) {
		this.stockId = stockId;
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
