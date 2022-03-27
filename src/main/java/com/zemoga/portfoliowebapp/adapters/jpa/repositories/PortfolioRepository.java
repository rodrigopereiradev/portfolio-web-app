package com.zemoga.portfoliowebapp.adapters.jpa.repositories;

import com.zemoga.portfoliowebapp.adapters.jpa.entities.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Integer> {
}
