package com.zemoga.portfoliowebapp.adapters.clients;

import com.zemoga.portfoliowebapp.adapters.dtos.TwitterResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
public class TwitterClient {

    @Value(value = "${twitter.max.timeline.result}")
    private String twitterTimelineMaxResult;

    @Value(value = "${twitter.api.bearer.token}")
    private String token;

    public Optional<TwitterResponseDTO> getTimeline(String userId) {

        var url = String.format("https://api.twitter.com/2/users/%s/tweets", userId);

        var client = WebClient.builder().baseUrl(url).build();

        var resp = client
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .queryParam("max_results", twitterTimelineMaxResult)
                                .build())
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(TwitterResponseDTO.class);

        return resp.blockOptional();
    }
}
