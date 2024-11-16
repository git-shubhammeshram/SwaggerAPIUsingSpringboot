package com.coderandrider.Controller;

import com.coderandrider.DTO.StockDTO;
import com.coderandrider.Entity.Stock;
import com.coderandrider.Repository.StockRepository;
import com.coderandrider.Service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/stock")
public class Controller {

	@Autowired
	private StockService stockService;
	@PostMapping()
	@Operation(summary = "Add the stock")
	public ResponseEntity<String> addStockHandler(@RequestBody StockDTO stock){
		String response = stockService.addStock(stock);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	@Operation(summary = "Get all the stock")
	public ResponseEntity<List<StockDTO>> getAllStockHandler(){
		List<StockDTO> response = stockService.getAllStockList();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@GetMapping("/{stockId}")
	@Operation(summary = "Get a single stock")
	public ResponseEntity<StockDTO> getStockByIdHandler(@PathVariable Long stockId){
		StockDTO response = stockService.getSingleStock(stockId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@PutMapping("/{stockId}")
	@Operation(summary = "Update the stock")
	public ResponseEntity<String> updateStockHandler(@PathVariable Long stockId, @RequestBody StockDTO stockDTO){
		String response = stockService.updateStock(stockId, stockDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@DeleteMapping("/{stockId}")
	@Operation(summary = "Delete the stock")
	public ResponseEntity<String> deleteStockHandler(@PathVariable Long stockId){
		String response = stockService.deleteStock(stockId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
