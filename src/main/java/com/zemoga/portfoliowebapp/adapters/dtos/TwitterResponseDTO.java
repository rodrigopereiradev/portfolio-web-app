package com.zemoga.portfoliowebapp.adapters.dtos;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TwitterResponseDTO {

    List<Twitter> data;

}
