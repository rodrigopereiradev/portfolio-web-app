package com.zemoga.portfoliowebapp.domain.ports;

import com.zemoga.portfoliowebapp.domain.models.Twitter;

import java.util.List;

public interface TwitterOutPort {

    List<Twitter> getTimeline(String twitterUserId);
}
