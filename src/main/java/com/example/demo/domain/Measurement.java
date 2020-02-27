package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "measurement")
//@JsonIgnoreProperties("product")
public class Measurement {
  @Id// данное поле — primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  long id;
  @Column(name = "measure", nullable = false, unique = true)
  String measure;
  //  @JsonView(Views.IdName.class)

  /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "measurement")
  @JsonManagedReference
  @JsonIgnore
  private Set<Product> product;*/


  /*public Set<Product> getProduct() {
    return product;
  }

  public void setProduct(Set<Product> product) {
    this.product = product;
  }*/


  public Measurement() {
  }

  public Measurement(String measure) {
    this.measure = measure;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }
}