package com.example.demo.repo;

import com.example.demo.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepo extends JpaRepository<Provider, Long> {
}
