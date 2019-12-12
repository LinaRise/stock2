package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
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
  @JsonBackReference
//  @OnDelete(action = OnDeleteAction.CASCADE)
  private Stock stock;

  @ManyToOne(optional = false) // cascade = CascadeType.ALL
  @JoinColumn(name = "provider_id")
  @JsonBackReference
//  @OnDelete(action = OnDeleteAction.CASCADE)
  private Provider provider;


  @OneToMany(mappedBy = "outcome_bill")
  @JsonManagedReference
  Set<OutcomeStrings> outcomeStrings;


}
