package com.zemoga.portfoliowebapp.domain.usecases;

import com.zemoga.portfoliowebapp.domain.models.Twitter;

import java.util.List;

public interface ITwitterUseCase {

    List<Twitter> getTimeline(String twitterUserId);

}
