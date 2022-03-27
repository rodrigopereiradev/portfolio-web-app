package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.clients.TwitterClient;
import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TwitterGateway implements TwitterOutPort {

    private final TwitterClient twitterClient;

    @Override
    public List<Twitter> getTimeline(String twitterUserId) {
        var twitterResponse = twitterClient.getTimeline(twitterUserId);

        if (twitterResponse.isEmpty())
            return Collections.emptyList();

        return twitterResponse.get().getData();

    }

}
