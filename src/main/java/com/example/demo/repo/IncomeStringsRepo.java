package com.example.demo.repo;

import com.example.demo.domain.IncomeStrings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeStringsRepo extends JpaRepository<IncomeStrings,Long> {
}
