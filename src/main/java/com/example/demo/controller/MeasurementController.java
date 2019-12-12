package com.example.demo.controller;

import com.example.demo.domain.Measurement;
import com.example.demo.repo.MeasurementRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("measurement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MeasurementController {
  private final MeasurementRepo measurementRepo;

  @Autowired
  public MeasurementController(MeasurementRepo measurementRepo) {
    this.measurementRepo = measurementRepo;
  }


  @GetMapping()
  public List<Measurement> list() {
    return measurementRepo.findAll();
  }

  @GetMapping("{id}")
  public Measurement getOne(@PathVariable("id") Measurement measurement) {
    return measurement;
  }


  @PostMapping()
  public Measurement create(@RequestBody Measurement measurement) {
    Measurement measurement1 = new Measurement();
    BeanUtils.copyProperties(measurement, measurement1, "id");
    return measurementRepo.save(measurement1);
  }

  @PutMapping("{id}")
  public Measurement update(
          @PathVariable("id") Measurement measurementFromDb,
          @RequestBody Measurement measurement
  ) {
    BeanUtils.copyProperties(measurement, measurementFromDb, "id");

    return measurementRepo.save(measurementFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Measurement measurement) {
    measurementRepo.delete(measurement);
  }
}