package com.zemoga.portfoliowebapp.domain.usecases.implementations;

import com.zemoga.portfoliowebapp.domain.models.Twitter;
import com.zemoga.portfoliowebapp.domain.ports.TwitterOutPort;
import com.zemoga.portfoliowebapp.domain.usecases.ITwitterUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TwitterUseCase implements ITwitterUseCase {

    private final TwitterOutPort twitterOutPort;

    @Override
    public List<Twitter> getTimeline(String twitterUserId) {
        return twitterOutPort.getTimeline(twitterUserId);
    }
}
