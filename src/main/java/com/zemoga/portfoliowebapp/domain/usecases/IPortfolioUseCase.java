package com.zemoga.portfoliowebapp.domain.usecases;

import com.zemoga.portfoliowebapp.domain.models.Portfolio;

import java.util.List;

public interface IPortfolioUseCase {

    Portfolio findById(Integer id);

    void update(Portfolio portfolio);

    List<Portfolio> findAll();
}
