package com.zemoga.portfoliowebapp.adapters.dtos;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioResponseDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String description;
    private String experience;
    private String imageUrl;
    private String twitterUserId;

    private List<Twitter> twitters;

    public String getCompleteName() {
        return name + " " + lastName;
    }

}
