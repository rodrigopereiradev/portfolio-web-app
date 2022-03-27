package com.zemoga.portfoliowebapp.adapters.dtos;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class PortfolioDTO {

    @Setter
    private Integer id;

    private String name;
    private String lastName;
    private String description;
    private String experienceSummary;
    private String imageUrl;
    private String twitterUserId;
    private List<Twitter> twitters;

}
