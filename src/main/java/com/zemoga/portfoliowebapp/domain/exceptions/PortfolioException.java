package com.zemoga.portfoliowebapp.domain.exceptions;

import java.io.Serializable;

public class PortfolioException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4016241477399957727L;

    public PortfolioException(String message) {
        super(message);
    }
}
