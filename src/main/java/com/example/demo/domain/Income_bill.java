package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "income_bill")
public class Income_bill {
  @Id// данное поле — primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;

  @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "stock_id")
  @JsonBackReference
  private Stock stock;

  @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "provider_id")
  @JsonBackReference
  private Provider provider;

  @JsonManagedReference
  @OneToMany(mappedBy = "income_bill")
  Set<IncomeStrings> incomeStrings;



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

  public Set<IncomeStrings> getIncomeStrings() {
    return incomeStrings;
  }

  public void setIncomeStrings(Set<IncomeStrings> incomeStrings) {
    this.incomeStrings = incomeStrings;
  }
}
