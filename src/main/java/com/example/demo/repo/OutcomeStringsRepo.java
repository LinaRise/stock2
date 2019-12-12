package com.example.demo.repo;

import com.example.demo.domain.OutcomeStrings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeStringsRepo extends JpaRepository<OutcomeStrings,Long> {
}
