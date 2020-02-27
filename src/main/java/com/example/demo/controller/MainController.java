package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/") //на главную старничку
public class MainController {
  private final MeasurementRepo measurementRepo;
  private final ProductRepo productRepo;
  private final Income_billRepo income_billRepo;
  private final IncomeStringsRepo incomeStringsRepo;
  private final OutcomeStringsRepo outcomeStringsRepo;
  private final Outcome_billRepo outcome_billRepo;
  private final ProviderRepo providerRepo;
  private final StockRepo stockRepo;

  @Value("${spring.profiles.active}")
 public String profile;

  @Autowired
  public MainController(MeasurementRepo measurementRepo, ProductRepo productRepo, Income_billRepo income_billRepo, IncomeStringsRepo incomeStringsRepo, OutcomeStringsRepo outcomeStringsRepo, Outcome_billRepo outcome_billRepo, ProviderRepo providerRepo, StockRepo stockRepo) {
    this.measurementRepo = measurementRepo;
    this.productRepo = productRepo;
    this.income_billRepo = income_billRepo;
    this.incomeStringsRepo = incomeStringsRepo;
    this.outcomeStringsRepo = outcomeStringsRepo;
    this.outcome_billRepo = outcome_billRepo;
    this.providerRepo = providerRepo;
    this.stockRepo = stockRepo;
  }


  @GetMapping
  public String main(Model model, @AuthenticationPrincipal User user) {
    HashMap<Object, Object> data = new HashMap<>();

    if(user!=null) {//чтобы не отображались данные, если мы еще не авторизованы
      data.put("profile", user);
//    data.put("measurements", measurementRepo.findAll());
/*      data.put("measurements", measurementRepo.findAll());
      data.put("products", productRepo.findAll());
      data.put("providers", providerRepo.findAll());
      data.put("income_bills", income_billRepo.findAll());
      data.put("incomeStringss", incomeStringsRepo.findAll());
      data.put("outcome_bills", outcome_billRepo.findAll());
      data.put("outcomeStringss", outcomeStringsRepo.findAll());
      data.put("stocks", stockRepo.findAll());*/
    }

    model.addAttribute("frontendData", data);
    model.addAttribute("isDevMode", "dev".equals(profile));

    return "index";
  }

//  @GetMapping
//  public String main(Model model, @AuthenticationPrincipal User user){
//    HashMap<Object, Object> data = new HashMap<>();
//    data.put("profile",user);
//    data.put("measurements",null);
//    model.addAttribute("frontendData",data);
//    return "index";
//  }
}

