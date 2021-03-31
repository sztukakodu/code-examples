package pl.sztukakodu.live.tweets.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sztukakodu.live.tweets.domain.Tweet;

public interface TweetsRepository extends JpaRepository<Tweet, String> {

}
