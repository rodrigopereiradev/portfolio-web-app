package com.zemoga.portfoliowebapp.domain.exceptions;

public class PortfolioNotFoundException extends RuntimeException {

    public PortfolioNotFoundException(String message) {
        super(message);;
    }
}
