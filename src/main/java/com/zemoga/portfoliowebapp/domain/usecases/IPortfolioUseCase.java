package com.zemoga.portfoliowebapp.domain.usecases;

import com.zemoga.portfoliowebapp.domain.models.Portfolio;

public interface IPortfolioUseCase {

    Portfolio findById(Integer id);

    void update(Portfolio portfolio);
}
