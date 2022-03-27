package com.zemoga.portfoliowebapp.domain.ports;

import com.zemoga.portfoliowebapp.domain.models.Portfolio;

public interface PortfolioOutPort {

    Portfolio findById(Integer id);

    void save(Portfolio portfolio);
}
