package com.zemoga.portfoliowebapp.domain.exceptions;

import java.io.Serializable;

public class PortfolioNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -3438911457392326750L;

    public PortfolioNotFoundException(String message) {
        super(message);

    }
}
