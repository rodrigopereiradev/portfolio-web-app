package com.zemoga.portfoliowebapp.domain.usecases.implementations;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import com.zemoga.portfoliowebapp.domain.usecases.ITwitterUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class TwitterUseCase implements ITwitterUseCase {

    private final TwitterOutPort twitterOutPort;

    @Override
    public List<Twitter> getTimeline(String twitterUserId) {

        if (Objects.isNull(twitterUserId))
            return Collections.emptyList();

        return twitterOutPort.getTimeline(twitterUserId);
    }
}
