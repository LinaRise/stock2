package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "outcome_bill")
public class Outcome_bill {
  @Id// данное поле — primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;

  @ManyToOne(optional = false) // cascade = CascadeType.ALL
  @JoinColumn(name = "stock_id")
  //@JsonBackReference
//  @OnDelete(action = OnDeleteAction.CASCADE)
  private Stock stock;

  @ManyToOne(optional = false) // cascade = CascadeType.ALL
  @JoinColumn(name = "provider_id")
  //@JsonBackReference
//  @OnDelete(action = OnDeleteAction.CASCADE)
  private Provider provider;


  @OneToMany(mappedBy = "outcome_bill")
  @JsonManagedReference
  List<OutcomeStrings> outcomeStrings;

  public Outcome_bill() {
  }

  public Outcome_bill(Stock stock, Provider provider, List<OutcomeStrings> outcomeStrings) {
    this.stock = stock;
    this.provider = provider;
    this.outcomeStrings = outcomeStrings;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Stock getStock() {
    return stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public List<OutcomeStrings> getOutcomeStrings() {
    return outcomeStrings;
  }

  public void setOutcomeStrings(List<OutcomeStrings> outcomeStrings) {
    this.outcomeStrings = outcomeStrings;
  }
}
