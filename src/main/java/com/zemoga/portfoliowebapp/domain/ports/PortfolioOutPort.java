package com.zemoga.portfoliowebapp.domain.ports;

import com.zemoga.portfoliowebapp.domain.models.Portfolio;

import java.util.List;

public interface PortfolioOutPort {

    Portfolio findById(Integer id);

    void save(Portfolio portfolio);

    List<Portfolio> findAll();
}
