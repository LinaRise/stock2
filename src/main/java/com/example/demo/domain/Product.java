package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "price", nullable = false)
  private int price;

  @ManyToOne//persist, тк чтобы каскад распростаранялся только на сохранение и изменние, а не на удаление
  @JoinColumn(name = "measurement_id",nullable = false)
  //@JsonBackReference
  private Measurement measurement;

/*  @OneToMany(mappedBy = "product")
  @JsonManagedReference
  Set<OutcomeStrings> outcomeStrings;*/

  public void setId(long id) {
    this.id = id;
  }

/*
  @OneToMany(mappedBy = "product")
  @JsonManagedReference
  Set<IncomeStrings> incomeStrings;
*/



  public Product() {
  }

  public Product(String title, int price, Measurement measurement) {
    this.title = title;
    this.price = price;
    this.measurement = measurement;
  }

  public Product(String title, int price, Measurement measurement, Set<OutcomeStrings> outcomeStrings, Set<IncomeStrings> incomeStrings) {
    this.title = title;
    this.price = price;
    this.measurement = measurement;
   // this.outcomeStrings = outcomeStrings;
   // this.incomeStrings = incomeStrings;
  }

  /*public Set<OutcomeStrings> getOutcomeStrings() {
    return outcomeStrings;
  }

  public void setOutcomeStrings(Set<OutcomeStrings> outcomeStrings) {
    this.outcomeStrings = outcomeStrings;
  }

  public Set<IncomeStrings> getIncomeStrings() {
    return incomeStrings;
  }

  public void setIncomeStrings(Set<IncomeStrings> incomeStrings) {
    this.incomeStrings = incomeStrings;
  }*/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }



  public long getMeasurementId() {
    return measurement.getId();
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Measurement getMeasurement() {
    return measurement;
  }

  public void setMeasurement(Measurement measurement) {
    this.measurement = measurement;
  }


}
