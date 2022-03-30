package com.zemoga.portfoliowebapp.adapters.clients;

import com.zemoga.portfoliowebapp.adapters.dtos.TokenResponseDTO;
import com.zemoga.portfoliowebapp.adapters.dtos.TwitterResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

@Component
public class TwitterClient {

    @Value("${twitter.api.key}")
    private String twitterApiKey;

    @Value("${twitter.api.secret.key}")
    private String twitterApiSecretKey;

    @Value(value = "${twitter.max.timeline.result}")
    private String twitterTimelineMaxResult;

    @Value("${twitter.token.url}")
    private String twitterTokenUrl;

    public Optional<TwitterResponseDTO> getTimeline(String userId) {

        var url = String.format("https://api.twitter.com/2/users/%s/tweets", userId);

        return getWebClient(url)
                .get()
                .uri(getMaxResultQueryParam())
                .header("Authorization", getToken())
                .retrieve()
                .bodyToMono(TwitterResponseDTO.class)
                .blockOptional();

    }

    private String getToken() {

        var resp = getWebClient(twitterTokenUrl)
                .post()
                .headers(httpHeaders -> httpHeaders.setBasicAuth(twitterApiKey, twitterApiSecretKey))
                .retrieve()
                .bodyToMono(TokenResponseDTO.class);

        if (resp.blockOptional().isEmpty())
            return "";

        return resp.blockOptional().get().getToken();

    }

    private WebClient getWebClient(String url) {
        return WebClient.builder().baseUrl(url).build();
    }

    private Function<UriBuilder, URI> getMaxResultQueryParam() {
        return uriBuilder -> uriBuilder
                .queryParam("max_results", twitterTimelineMaxResult)
                .build();
    }

}
