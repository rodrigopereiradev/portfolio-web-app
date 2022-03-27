package com.zemoga.portfoliowebapp.adapters.mappers;

import com.zemoga.portfoliowebapp.adapters.dtos.PortfolioDTO;
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

    public Portfolio fromDTO(PortfolioDTO portfolioDTO) {
        return Portfolio.builder()
                .id(portfolioDTO.getId())
                .name(portfolioDTO.getName())
                .lastName(portfolioDTO.getLastName())
                .description(portfolioDTO.getDescription())
                .experienceSummary(portfolioDTO.getExperienceSummary())
                .imageUrl(portfolioDTO.getImageUrl())
                .twitterUserId(portfolioDTO.getTwitterUserId())
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
