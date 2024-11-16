package com.coderandrider.Service;

import com.coderandrider.DTO.StockDTO;
import com.coderandrider.Entity.Stock;
import com.coderandrider.Exception.ResourceNotFoundException;
import com.coderandrider.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public String addStock(StockDTO stockDTO){
		Stock stock = convertEntity(stockDTO);
		Stock savedStock = stockRepository.save(stock);
		convertDTO(savedStock);
		return "Stock Added Successfully";
	}

	public List<StockDTO> getAllStockList(){
		return stockRepository.findAll()
				.stream()
				.map(this::convertDTO)
				.toList();
	}

	public StockDTO getSingleStock(Long stockId){
		return stockRepository.findById(stockId)
				.map(this::convertDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find the stock"));
	}

	public String updateStock(Long stockId, StockDTO stockDTO){
		Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
		stock.setStockName(stockDTO.getStockName());
		stock.setStockPrice(stockDTO.getStockPrice());
		Stock savedStock = stockRepository.save(stock);
		convertDTO(savedStock);
		return "Stock Updated Successfully";
	}

	public String deleteStock(Long stockId){
		if(stockRepository.existsById(stockId)){
			stockRepository.deleteById(stockId);
			return "Stock deleted successfully";
		}
		else {
			throw new ResourceNotFoundException("Stock not found");
		}
	}

	public StockDTO convertDTO(Stock stock){
		StockDTO stockDTO = new StockDTO();
		stockDTO.setStockId(stock.getStockId());
		stockDTO.setStockName(stock.getStockName());
		stockDTO.setStockPrice(stock.getStockPrice());
		return stockDTO;
	}

	public Stock convertEntity(StockDTO stockDTO){
		Stock stock = new Stock();
        stock.setStockName(stockDTO.getStockName());
        stock.setStockPrice(stockDTO.getStockPrice());
        return stock;
	}
}
