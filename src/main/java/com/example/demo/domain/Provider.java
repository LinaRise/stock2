package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "provider")
@RequestMapping("provider")
@JsonIgnoreProperties({"outcome_bills","income_bills"})
public class Provider {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  long id;
  @Column(name = "title", nullable = false)
  private String title;
  private String contact_name;
  private String phone_number;
  @Column(name = "address", nullable = false)
  private String address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
  @JsonManagedReference
  private Set<Outcome_bill> outcome_bills;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
  @JsonManagedReference
  private Set<Income_bill> income_bills;

  public Provider() {
  }

  public Provider(String title, String contact_name, String phone_number, String address) {
    this.title = title;
    this.contact_name = contact_name;
    this.phone_number = phone_number;
    this.address = address;
  }


  public Set<Income_bill> getIncome_bills() {
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
  }

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

  public String getContact_name() {
    return contact_name;
  }

  public void setContact_name(String contact_name) {
    this.contact_name = contact_name;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
