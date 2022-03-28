package com.zemoga.portfoliowebapp.domain.usecases.implementations;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TwitterUseCaseTest {

    @Mock
    private TwitterOutPort port;

    @InjectMocks
    private TwitterUseCase useCase;

    @Test
    void shouldReturnAtLeastOneTwitter() {

        Mockito.when(port.getTimeline("1111"))
                .thenReturn(Collections.singletonList(Twitter.builder().build()));

        var twitters = useCase.getTimeline("1111");

        assertFalse(twitters.isEmpty());

    }

    @Test
    void shouldReturnEmptyListWhenTwitterUserIdIsNull() {

        var twitters = useCase.getTimeline(null);

        assertTrue(twitters.isEmpty());

    }
}
