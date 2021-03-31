package pl.sztukakodu.live.tweets.application.ports;

import pl.sztukakodu.live.tweets.domain.Tweet;

import java.util.List;

public interface TweetsQueryUseCase {

    List<Tweet> fetchAll();

}
