package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.jpa.repositories.PortfolioRepository;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import com.zemoga.portfoliowebapp.domain.ports.PortfolioOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class PortfolioGateway implements PortfolioOutPort {

    private final PortfolioMapper mapper;
    private final PortfolioRepository repository;

    @Override
    public Portfolio findById(Integer id) {
        var portfolioEntity = repository.findById(id);

        if (portfolioEntity.isEmpty())
            throw new EntityNotFoundException("Portfolio not found.");

        return mapper.fromEntity(portfolioEntity.get());
    }

    @Override
    public void save(Portfolio portfolio) {
        var portifolioEntity = mapper.toEntity(portfolio);
        repository.save(portifolioEntity);
    }
}
