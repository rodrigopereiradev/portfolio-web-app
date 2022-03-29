package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.clients.TwitterClient;
import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TwitterGateway implements TwitterOutPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterGateway.class);
    private final TwitterClient twitterClient;

    @Override
    public List<Twitter> getTimeline(String twitterUserId) {
        try {
            var twitterResponse = twitterClient.getTimeline(twitterUserId);

            if (twitterResponse.isEmpty())
                return Collections.emptyList();

            return twitterResponse.get().getData();
        } catch (Exception e) {
            LOGGER.error("An error occurred while retrieving the Twitter timeline.", e.getCause());
            return Collections.emptyList();
        }

    }

}
