package com.zemoga.portfoliowebapp.domain.models;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 827365043332991661L;

    private final Integer id;
    private String name;
    private String lastName;
    private String description;
    private String experience;
    private String imageUrl;
    private String twitterUserId;
    private List<Twitter> twitters;

    public void addTwitters(List<Twitter> twitters) {
        if (Objects.isNull(this.twitters))
            this.twitters = new ArrayList<>();

        this.twitters.addAll(twitters);
    }

    public void update(Portfolio portfolio) {
        this.name = portfolio.getName();
        this.lastName = portfolio.getLastName();
        this.description = portfolio.getDescription();
        this.experience = portfolio.getExperience();
        this.imageUrl = portfolio.getImageUrl();
        this.twitterUserId = portfolio.getTwitterUserId();
    }
}
