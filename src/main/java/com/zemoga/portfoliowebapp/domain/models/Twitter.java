package com.zemoga.portfoliowebapp.domain.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Twitter implements Serializable {

    private static final long serialVersionUID = 39562438610169474L;

    private String id;
    private String text;
}
