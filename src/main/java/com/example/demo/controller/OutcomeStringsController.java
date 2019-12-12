package com.example.demo.controller;

import com.example.demo.domain.OutcomeStrings;
import com.example.demo.repo.OutcomeStringsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("outcomeStrings")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OutcomeStringsController {
  private final OutcomeStringsRepo outcomeStringsRepo;

  @Autowired
  public OutcomeStringsController(OutcomeStringsRepo outcomeStringsRepo) {
    this.outcomeStringsRepo = outcomeStringsRepo;
  }

  @GetMapping()
  public List<OutcomeStrings> list() {
    return outcomeStringsRepo.findAll();
  }

  @GetMapping("{id}")
  public OutcomeStrings getOne(@PathVariable("id") OutcomeStrings outcomeStrings) {
    return outcomeStrings;
  }





  @PostMapping()
  public OutcomeStrings create(@RequestBody OutcomeStrings outcomeStrings) {
    OutcomeStrings outcomeStrings1 = new OutcomeStrings();
    BeanUtils.copyProperties(outcomeStrings, outcomeStrings1, "id");
    return outcomeStringsRepo.save(outcomeStrings1);
  }

  @PutMapping("{id}")
  public OutcomeStrings update(
          @PathVariable("id") OutcomeStrings outcomeStringsFromDb,
          @RequestBody OutcomeStrings outcomeStrings
  ) {
    BeanUtils.copyProperties(outcomeStrings, outcomeStringsFromDb, "id");

    return outcomeStringsRepo.save(outcomeStringsFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") OutcomeStrings outcomeStrings) {
    outcomeStringsRepo.delete(outcomeStrings);
  }
}




