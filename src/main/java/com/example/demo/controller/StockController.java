package com.example.demo.controller;


import com.example.demo.domain.Stock;
import com.example.demo.repo.StockRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StockController {
  private final StockRepo stockRepo;

  @Autowired
  public StockController(StockRepo stockRepo) {
    this.stockRepo = stockRepo;
  }



  @GetMapping
//  @JsonView(Views.IdName.class)
  public List<Stock> list() {
    return stockRepo.findAll();
  }

  @GetMapping("{id}")
//  @JsonView(Views.FullMessage.class)
  public Stock getOne(@PathVariable("id") Stock stock) {
    return stock;
  }


  @PostMapping()
  public Stock create(@RequestBody Stock stock) {
    Stock stock1 = new Stock();
    BeanUtils.copyProperties(stock, stock1, "id");
    return stockRepo.save(stock1);
  }

  @PutMapping("{id}")
  public Stock update(
          @PathVariable("id") Stock stockFromDb,
          @RequestBody Stock stock
  ) {
    BeanUtils.copyProperties(stock, stockFromDb, "id");

    return stockRepo.save(stockFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id")Stock stock) {
    stockRepo.delete(stock);
  }
}
