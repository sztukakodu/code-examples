package pl.sztukakodu.live.tweets.application.ports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.sztukakodu.live.tweets.domain.Tweet;

public interface TweetsQueryUseCase {

    Page<Tweet> fetchAll(Pageable pageable);

}
