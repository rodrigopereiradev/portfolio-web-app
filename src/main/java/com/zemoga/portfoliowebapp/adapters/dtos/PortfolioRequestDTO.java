package com.zemoga.portfoliowebapp.adapters.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioRequestDTO {

    @Setter
    private Integer id;

    @NotBlank(message = "Field name is mandatory.")
    @Size(max = 255, message = "The field name can not have more than 255 characters.")
    private String name;

    @NotBlank(message = "Field lastName is mandatory.")
    @Size(max = 255, message = "The field lastName can not have more than 255 characters.")
    private String lastName;

    @Size(max = 255, message = "The field description can not have more than 255 characters.")
    private String description;

    @Size(max = 255, message = "The field experience can not have more than 255 characters.")
    private String experience;

    @Size(max = 255, message = "The field imageUrl can not have more than 255 characters.")
    private String imageUrl;

    @Size(max = 255, message = "The field twitterUserId can not have more than 255 characters.")
    private String twitterUserId;

}
