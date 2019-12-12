package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repo.MeasurementRepo;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {
  private final ProductRepo productRepo;

  @Autowired
  public ProductController(ProductRepo productRepo, JdbcOperations jdbcOperations, MeasurementRepo measurementRepo) {
    this.productRepo = productRepo;
  }

  @GetMapping()
  public List<Product> list() {
    return productRepo.findAll();
  }

  @GetMapping("{id}")
  public Product getOne(@PathVariable("id") Product product) {
    return product;
  }


//  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
//          "application/json"})
//  public ResponseEntity createTodo(@RequestBody Product product) {
////    Product product1 = new Todo(payload.isDone(), payload.getTask());
//    jdbcOperations.update("insert into product (id, title, properites, price, measurement_id) values (?, ?, ?, ?,?) S",
//            todo.getId().toString(), Timestamp.valueOf(todo.getDateCreated()),
//            todo.isDone(), todo.getTask());
//
//    return ResponseEntity.ok(todo);
//  }


  @PostMapping()
  public Product create(@RequestBody Product product) {
    Product product1 = new Product();
    BeanUtils.copyProperties(product, product1, "id");
    return productRepo.save(product1);
  }

  @PutMapping("{id}")
  public Product update(
          @PathVariable("id") Product productFromDb,
          @RequestBody Product product
  ) {
    BeanUtils.copyProperties(product, productFromDb, "id");

    return productRepo.save(productFromDb);
  }

  @DeleteMapping("{id}")
  public Product delete(@PathVariable("id") Product product) {
    productRepo.delete(product);
    return product;
  }
}



