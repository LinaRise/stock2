package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "incomeStrings")
public class IncomeStrings {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;

  @ManyToOne
  //@JsonBackReference
  @JoinColumn(name = "product_id",nullable = false)
  Product product;

  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "income_bill_id",nullable = false)
  Income_bill income_bill;

  @Column(name = "count", nullable = false)
  int count;

  public IncomeStrings() {

  }

  public IncomeStrings(Product product, Income_bill income_bill, int count) {
    this.product = product;
    this.income_bill = income_bill;
    this.count = count;
  }

  public long getId() {

    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Income_bill getIncome_bill() {
    return income_bill;
  }

  public void setIncome_bill(Income_bill income_bill) {
    this.income_bill = income_bill;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
