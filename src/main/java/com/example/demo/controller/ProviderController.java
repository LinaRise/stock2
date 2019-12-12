package com.example.demo.controller;


import com.example.demo.domain.Provider;
import com.example.demo.repo.ProviderRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProviderController {
  private final ProviderRepo providerRepo;

  @Autowired
  public ProviderController(ProviderRepo providerRepo) {
    this.providerRepo = providerRepo;
  }

  @GetMapping()
  public List<Provider> list() {
    return providerRepo.findAll();
  }

  @GetMapping("{id}")
  public Provider getOne(@PathVariable("id") Provider provider) {
    return provider;
  }



  @PostMapping
  public Provider create(@RequestBody Provider provider) {
    Provider provider1 = new Provider();
    BeanUtils.copyProperties(provider, provider1, "id");
    return providerRepo.save(provider1);
  }

  @PutMapping("{id}")
  public Provider update(
          @PathVariable("id") Provider providerFromDb,
          @RequestBody Provider provider
  ) {
    BeanUtils.copyProperties(provider, providerFromDb, "id");

    return providerRepo.save(providerFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Provider provider) {
    providerRepo.delete(provider);
  }
}


