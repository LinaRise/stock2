package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stock")
//@RequestMapping("stock")
//@JsonIgnoreProperties({"outcome_bills", "income_bills"})
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;
  @Column(name = "title", nullable = false, unique = true)
  String title;
  @Column(name = "address", nullable = false)
  String address;

  /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
  @JsonManagedReference
  private Set<Outcome_bill> outcome_bills;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
  @JsonManagedReference
  private Set<Income_bill> income_bills;*/

  public Stock() {

  }

  public Stock(String title, String address) {
    this.title = title;
    this.address = address;
  }

  /*public Set<Income_bill> getIncome_bills() {
    return income_bills;
  }

  public void setIncome_bills(Set<Income_bill> income_bills) {
    this.income_bills = income_bills;
  }

  public Set<Outcome_bill> getOutcome_bills() {
    return outcome_bills;
  }

  public void setOutcome_bills(Set<Outcome_bill> outcome_bills) {
    this.outcome_bills = outcome_bills;
  }*/

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
