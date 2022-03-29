package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.jpa.repositories.PortfolioRepository;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.exceptions.PortfolioException;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import com.zemoga.portfoliowebapp.domain.ports.PortfolioOutPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PortfolioGateway implements PortfolioOutPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioGateway.class.getName());

    private final PortfolioMapper mapper;
    private final PortfolioRepository repository;

    @Override
    public Portfolio findById(Integer id) {
        try {
            var portfolioEntity = repository.findById(id);

            if (portfolioEntity.isEmpty())
                throw new EntityNotFoundException("Portfolio not found.");

            return mapper.fromEntity(portfolioEntity.get());
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            var msg = "An error occurred while retrieving the portfolio.";
            LOGGER.error(msg, e.getCause());
            throw new PortfolioException(msg);
        }
    }

    @Override
    public void save(Portfolio portfolio) {
        try {
            var portifolioEntity = mapper.toEntity(portfolio);
            repository.save(portifolioEntity);
        } catch (Exception e) {
            var msg = "An error occurred while saving the portfolio.";
            LOGGER.error(msg, e.getCause());
            throw new PortfolioException(msg);
        }
    }

    @Override
    public List<Portfolio> findAll() {
        try {
            var portfoliosEntities = repository.findAll();
            return portfoliosEntities.stream().map(mapper::fromEntity).collect(Collectors.toList());
        } catch (Exception e) {
            var msg = "An error occurred while retrieving all portfolios.";
            LOGGER.error(msg, e.getCause());
            throw new PortfolioException(msg);
        }
    }
}
