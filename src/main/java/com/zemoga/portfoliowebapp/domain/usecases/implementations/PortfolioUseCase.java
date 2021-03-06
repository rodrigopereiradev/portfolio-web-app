package com.zemoga.portfoliowebapp.domain.usecases.implementations;

import com.zemoga.portfoliowebapp.domain.exceptions.PortfolioNotFoundException;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import com.zemoga.portfoliowebapp.domain.ports.PortfolioOutPort;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import com.zemoga.portfoliowebapp.domain.usecases.ITwitterUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class PortfolioUseCase implements IPortfolioUseCase {

    private final PortfolioOutPort portfolioOutPort;
    private final ITwitterUseCase twitterUseCase;

    @Override
    public Portfolio findById(Integer id) {
        var portfolio = portfolioOutPort.findById(id);

        if (Objects.isNull(portfolio))
            throw new PortfolioNotFoundException("Portfolio not found.");

        var twitters = twitterUseCase.getTimeline(portfolio.getTwitterUserId());

        portfolio.addTwitters(twitters);

        return portfolio;
    }

    @Override
    public void update(Portfolio portfolio) {

        var portfolioToUpdate = findById(portfolio.getId());

        portfolioToUpdate.update(portfolio);

        portfolioOutPort.save(portfolio);

    }

    @Override
    public List<Portfolio> findAll() {
        return portfolioOutPort.findAll();
    }

}
