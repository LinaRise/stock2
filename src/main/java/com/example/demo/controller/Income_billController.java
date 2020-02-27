package com.example.demo.controller;

import com.example.demo.domain.Income_bill;
import com.example.demo.repo.Income_billRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomeBill")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Income_billController {
  private final Income_billRepo income_billRepo;

  @Autowired
  public Income_billController(Income_billRepo income_billRepo) {
    this.income_billRepo = income_billRepo;
  }


  @GetMapping()
  public List<Income_bill> list() {
    return income_billRepo.findAll();
  }

  @GetMapping("{id}")
  public Income_bill getOne(@PathVariable("id") Income_bill income_bill) {
    return income_bill;
  }

  @PostMapping()
  public Income_bill create(@RequestBody Income_bill income_bill) {
    Income_bill income_bill1 = new Income_bill();
    BeanUtils.copyProperties(income_bill,income_bill1,"id");
    return income_billRepo.save(income_bill1);
  }

  @PutMapping("{id}")
  public Income_bill update(
          @PathVariable("id") Income_bill income_billFromDb,
          @RequestBody Income_bill income_bill
  ) {
    BeanUtils.copyProperties(income_bill, income_billFromDb, "id");

    return income_billRepo.save(income_billFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Income_bill income_bill) {
    income_billRepo.delete(income_bill);
  }
}

