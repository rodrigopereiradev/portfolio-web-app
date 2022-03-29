package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.jpa.entities.PortfolioEntity;
import com.zemoga.portfoliowebapp.adapters.jpa.repositories.PortfolioRepository;
import com.zemoga.portfoliowebapp.adapters.mappers.PortfolioMapper;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PortfolioGatewayTest {

    @Mock
    private PortfolioMapper  mapper;

    @Mock
    private PortfolioRepository repository;

    @InjectMocks
    private PortfolioGateway gateway;

    @Test
    void shouldFindPortfolioById() {

        var portfolioEntity = PortfolioEntity.builder().id(1).build();

        when(repository.findById(1)).thenReturn(Optional.of(portfolioEntity));
        when(mapper.fromEntity(portfolioEntity)).thenReturn(Portfolio.builder().id(1).build());

        var portfolio = gateway.findById(1);

        assertNotNull(portfolio);
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenPortfolioNotFound() {

        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> gateway.findById(1));

    }

    @Test
    void shouldCallMethodSaveFromRepository() {

        var portfolio = Portfolio.builder().id(1).build();
        var portfolioEntity = PortfolioEntity.builder().id(1).build();

        when(mapper.toEntity(portfolio)).thenReturn(portfolioEntity);

        gateway.save(portfolio);

        verify(repository).save(portfolioEntity);

    }

    @Test
    void shouldBringAtListOnePortfolioWhenSearchingAll() {

        var portfolio = Portfolio.builder().id(1).build();
        var portfolioEntity = PortfolioEntity.builder().id(1).build();
        when(repository.findAll()).thenReturn(Collections.singletonList(portfolioEntity));
        when(mapper.fromEntity(portfolioEntity)).thenReturn(portfolio);

        var portfolios = gateway.findAll();

        assertFalse(portfolios.isEmpty());
    }

}
