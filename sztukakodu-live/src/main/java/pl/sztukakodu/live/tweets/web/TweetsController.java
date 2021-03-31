package pl.sztukakodu.live.tweets.web;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sztukakodu.live.tweets.application.ports.TweetsGenerateUseCase;
import pl.sztukakodu.live.tweets.application.ports.TweetsQueryUseCase;
import pl.sztukakodu.live.tweets.domain.Tweet;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@AllArgsConstructor
class TweetsController {

    private final TweetsQueryUseCase tweetsQuery;
    private final TweetsGenerateUseCase tweetsGenerate;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TweetsResponse getTweets() {
        return new TweetsResponse(tweetsQuery.fetchAll());
    }

    @PostMapping("/generate/{size}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void generate(@PathVariable("size") Long size) {
        tweetsGenerate.generate(size);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clean() {
        tweetsGenerate.clean();
    }

    @Value
    static class TweetsResponse {
        long count;
        List<Tweet> tweets;

        public TweetsResponse(List<Tweet> tweets) {
            this.tweets = tweets;
            this.count = tweets.size();
        }
    }
}
