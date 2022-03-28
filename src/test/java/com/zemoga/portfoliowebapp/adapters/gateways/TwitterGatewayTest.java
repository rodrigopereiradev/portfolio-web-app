package com.zemoga.portfoliowebapp.adapters.gateways;

import com.zemoga.portfoliowebapp.adapters.clients.TwitterClient;
import com.zemoga.portfoliowebapp.adapters.dtos.TwitterResponseDTO;
import com.zemoga.portfoliowebapp.domain.models.Twitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TwitterGatewayTest {

    @Mock
    private TwitterClient client;

    @InjectMocks
    private TwitterGateway gateway;

    @Test
    void shouldBringAtLeastOneTwitter() {

        var twitters = Collections.singletonList(Twitter.builder().text("Text").build());

        when(client.getTimeline("1111"))
                .thenReturn(Optional.of(TwitterResponseDTO.builder().data(twitters).build()));

        var twitterResp = gateway.getTimeline("1111");

        assertFalse(twitterResp.isEmpty());
    }

    @Test
    void shouldBringEmptyListWhenClientDontBringNothing() {

        when(client.getTimeline("1111")).thenReturn(Optional.empty());

        var twitterResp = gateway.getTimeline("1111");

        assertTrue(twitterResp.isEmpty());
    }
}
