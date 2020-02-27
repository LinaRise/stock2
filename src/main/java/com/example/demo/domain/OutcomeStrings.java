package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "outcomeStrings")
public class OutcomeStrings {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  //@JsonBackReference
  Product product;

  @ManyToOne
  @JoinColumn(name = "outcome_bill_id", nullable = false)
  @JsonBackReference
  Outcome_bill outcome_bill;

  @Column(name = "count", nullable = false)
  int count;

  public OutcomeStrings() {
  }

  public OutcomeStrings(Product product, Outcome_bill outcome_bill, int count) {
    this.product = product;
    this.outcome_bill = outcome_bill;
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

  public Outcome_bill getOutcome_bill() {
    return outcome_bill;
  }

  public void setOutcome_bill(Outcome_bill outcome_bill) {
    this.outcome_bill = outcome_bill;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
