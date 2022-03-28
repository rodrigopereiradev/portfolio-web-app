package com.zemoga.portfoliowebapp.domain.usecases.implementations;

import com.zemoga.portfoliowebapp.domain.exceptions.PortfolioNotFoundException;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import com.zemoga.portfoliowebapp.domain.ports.PortfolioOutPort;
import com.zemoga.portfoliowebapp.domain.usecases.ITwitterUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PortfolioUseCaseTest {

    @Mock
    private PortfolioOutPort portfolioOutPort;

    @Mock
    private ITwitterUseCase iTwitterUseCase;

    @InjectMocks
    private PortfolioUseCase portfolioUseCase;

    private Portfolio portfolioToUpdate;

    private Portfolio portfolioWithNewInfo;

    @BeforeEach
    void setUp() {
        portfolioToUpdate = buildPortfolioToUpdate();
        portfolioWithNewInfo = buildPortfolioWithNewInfo();
    }

    @Test
    void shouldReturnPortfolioById() {

        var portfolioMock = Portfolio.builder().id(1).twitterUserId("1111").build();

        when(portfolioOutPort.findById(1)).thenReturn(portfolioMock);
        when(iTwitterUseCase.getTimeline("1111")).thenReturn(Collections.emptyList());

        var portfolio = portfolioUseCase.findById(1);

        assertNotNull(portfolio);

    }

    @Test
    void shouldReturnPortfolioNotFoundExceptionWhenFindingPortfolioById() {

        when(portfolioOutPort.findById(1)).thenReturn(null);

        assertThrows(PortfolioNotFoundException.class, () -> portfolioUseCase.findById(1));

    }

    @Test
    void shouldUpdatePortfolioName() {
        when(portfolioOutPort.findById(1)).thenReturn(portfolioToUpdate);

        portfolioUseCase.update(portfolioWithNewInfo);

        assertEquals("Test Update", portfolioToUpdate.getName());

    }

    @Test
    void shouldUpdatePortfolioLastName() {
        when(portfolioOutPort.findById(1)).thenReturn(portfolioToUpdate);

        portfolioUseCase.update(portfolioWithNewInfo);

        assertEquals("Test Update", portfolioToUpdate.getLastName());

    }

    @Test
    void shouldUpdatePortfolioDescription() {
        when(portfolioOutPort.findById(1)).thenReturn(portfolioToUpdate);

        portfolioUseCase.update(portfolioWithNewInfo);

        assertEquals("Test Update", portfolioToUpdate.getDescription());

    }

    @Test
    void shouldUpdatePortfolioExperience() {
        when(portfolioOutPort.findById(1)).thenReturn(portfolioToUpdate);

        portfolioUseCase.update(portfolioWithNewInfo);

        assertEquals("Test Update", portfolioToUpdate.getExperienceSummary());

    }

    @Test
    void shouldUpdatePortfolioImageURL() {
        when(portfolioOutPort.findById(1)).thenReturn(portfolioToUpdate);

        portfolioUseCase.update(portfolioWithNewInfo);

        assertEquals("Test Update", portfolioToUpdate.getImageUrl());

    }

    private Portfolio buildPortfolioWithNewInfo() {
        return Portfolio.builder()
                .id(1)
                .name("Test Update")
                .lastName("Test Update")
                .description("Test Update")
                .experienceSummary("Test Update")
                .imageUrl("Test Update")
                .build();
    }

    private Portfolio buildPortfolioToUpdate() {
        return Portfolio.builder()
                .id(1)
                .name("Test")
                .lastName("Test")
                .description("Test")
                .experienceSummary("Test")
                .imageUrl("Test")
                .build();
    }
}
