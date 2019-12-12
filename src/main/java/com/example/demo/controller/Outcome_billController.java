package com.example.demo.controller;

import com.example.demo.domain.Outcome_bill;
import com.example.demo.repo.Outcome_billRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("outcomeBill")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Outcome_billController  {
  private final Outcome_billRepo outcome_billRepo;

  @Autowired
  public Outcome_billController(Outcome_billRepo outcome_billRepo) {
    this.outcome_billRepo = outcome_billRepo;
  }


  @GetMapping()
  public List<Outcome_bill> list() {
    return outcome_billRepo.findAll();
  }

  @GetMapping("{id}")
  public Outcome_bill getOne(@PathVariable("id") Outcome_bill outcome_bill) {
    return outcome_bill;
  }



  @PostMapping()
  public Outcome_bill create(@RequestBody Outcome_bill outcome_bill) {
    Outcome_bill outcome_bill1 = new Outcome_bill();
    BeanUtils.copyProperties(outcome_bill, outcome_bill1, "id");
    return outcome_billRepo.save(outcome_bill1);
  }

  @PutMapping("{id}")
  public Outcome_bill update(
          @PathVariable("id") Outcome_bill outcome_billFromDb,
          @RequestBody Outcome_bill outcome_bill
  ) {
    BeanUtils.copyProperties(outcome_bill, outcome_billFromDb, "id");

    return outcome_billRepo.save(outcome_billFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Outcome_bill outcome_bill) {
    outcome_billRepo.delete(outcome_bill);
  }
}



