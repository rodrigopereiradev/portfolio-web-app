package com.zemoga.portfoliowebapp.adapters.dtos;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDTO {

    @Setter
    private Integer id;

    @NotBlank(message = "Field name is mandatory.")
    @Size(max = 255, message = "The field name can not have more than 255 characters.")
    private String name;

    @NotEmpty(message = "Field lastName is mandatory.")
    @Size(max = 255, message = "The field lastName can not have more than 255 characters.")
    private String lastName;

    @Size(max = 255, message = "The field description can not have more than 255 characters.")
    private String description;

    @Size(max = 255, message = "The field experienceSummary can not have more than 255 characters.")
    private String experienceSummary;

    @Size(max = 255, message = "The field imageUrl can not have more than 255 characters.")
    private String imageUrl;

    @Size(max = 255, message = "The field twitterUserId can not have more than 255 characters.")
    private String twitterUserId;

    private List<Twitter> twitters;

}
