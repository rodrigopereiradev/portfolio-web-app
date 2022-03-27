package com.zemoga.portfoliowebapp.adapters.configs;

import com.zemoga.portfoliowebapp.domain.usecases.ITwitterUseCase;
import com.zemoga.portfoliowebapp.domain.usecases.IPortfolioUseCase;
import com.zemoga.portfoliowebapp.domain.ports.PortfolioOutPort;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import com.zemoga.portfoliowebapp.domain.usecases.implementations.PortfolioUseCase;
import com.zemoga.portfoliowebapp.domain.usecases.implementations.TwitterUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    IPortfolioUseCase portfolioInPort(PortfolioOutPort portfolioOutPort, ITwitterUseCase ITwitterUseCase) {
        return new PortfolioUseCase(portfolioOutPort, ITwitterUseCase);
    }

    @Bean
    ITwitterUseCase twitterInPort(TwitterOutPort twitterOutPort) {
        return new TwitterUseCase(twitterOutPort);
    }



}
