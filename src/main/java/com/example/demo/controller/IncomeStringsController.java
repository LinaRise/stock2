package com.example.demo.controller;

import com.example.demo.domain.IncomeStrings;
import com.example.demo.repo.IncomeStringsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomeStrings")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncomeStringsController {
  private final IncomeStringsRepo incomeStringsRepo;

  @Autowired
  public IncomeStringsController(IncomeStringsRepo incomeStringsRepo) {
    this.incomeStringsRepo = incomeStringsRepo;
  }

  @GetMapping()
  public List<IncomeStrings> list() {
    return incomeStringsRepo.findAll();
  }

  @GetMapping("{id}")
  public IncomeStrings getOne(@PathVariable("id") IncomeStrings incomeStrings) {
    return incomeStrings;
  }


  @PostMapping()
  public IncomeStrings create(@RequestBody IncomeStrings incomeStrings) {
    IncomeStrings incomeStrings1 = new IncomeStrings();
    BeanUtils.copyProperties(incomeStrings, incomeStrings1, "id");

    return incomeStringsRepo.save(incomeStrings1);
  }

  @PutMapping("{id}")
  public IncomeStrings update(
          @PathVariable("id") IncomeStrings incomeStringsFromDb,
          @RequestBody IncomeStrings incomeStrings
  ) {
    BeanUtils.copyProperties(incomeStrings, incomeStringsFromDb, "id");

    return incomeStringsRepo.save(incomeStringsFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") IncomeStrings incomeStrings) {
    incomeStringsRepo.delete(incomeStrings);
  }
}



