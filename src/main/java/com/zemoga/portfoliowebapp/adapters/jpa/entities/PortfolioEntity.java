package com.zemoga.portfoliowebapp.adapters.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "portfolio")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioEntity implements Serializable {

    private static final long serialVersionUID = -5646024632463317639L;

    @Id
    @Column(name = "idportfolio")
    private Integer id;

    @Column(name = "names")
    private String name;

    @Column(name = "last_names")
    private String lastName;

    @Column(name = "description")
    private String description;

    @Column(name = "experience")
    private String experience;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "twitter_user_id")
    private String twitterUserId;
}
