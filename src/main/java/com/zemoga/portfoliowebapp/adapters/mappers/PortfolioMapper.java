package com.zemoga.portfoliowebapp.adapters.mappers;

import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioDTO;
import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioRequestDTO;
import com.zemoga.portfoliowebapp.adapters.jpa.entities.PortfolioEntity;
import com.zemoga.portfoliowebapp.domain.models.Portfolio;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public Portfolio fromEntity(PortfolioEntity entity) {
        return Portfolio.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .description(entity.getDescription())
                .experienceSummary(entity.getExperienceSummary())
                .imageUrl(entity.getImageUrl())
                .twitterUserId(entity.getTwitterUserId())
                .build();
    }

    public PortfolioDTO toDTO(Portfolio portfolio) {
        return PortfolioDTO.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .lastName(portfolio.getLastName())
                .description(portfolio.getDescription())
                .experienceSummary(portfolio.getExperienceSummary())
                .imageUrl(portfolio.getImageUrl())
                .twitterUserId(portfolio.getTwitterUserId())
                .twitters(portfolio.getTwitters())
                .build();
    }

    public Portfolio fromDTO(PortfolioRequestDTO portfolioRequestDTO) {
        return Portfolio.builder()
                .id(portfolioRequestDTO.getId())
                .name(portfolioRequestDTO.getName())
                .lastName(portfolioRequestDTO.getLastName())
                .description(portfolioRequestDTO.getDescription())
                .experienceSummary(portfolioRequestDTO.getExperienceSummary())
                .imageUrl(portfolioRequestDTO.getImageUrl())
                .twitterUserId(portfolioRequestDTO.getTwitterUserId())
                .build();
    }

    public PortfolioEntity toEntity(Portfolio portfolio) {
        return PortfolioEntity.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .lastName(portfolio.getLastName())
                .description(portfolio.getDescription())
                .experienceSummary(portfolio.getExperienceSummary())
                .imageUrl(portfolio.getImageUrl())
                .twitterUserId(portfolio.getTwitterUserId())
                .build();
    }
}
