package pl.sztukakodu.live.tweets.application;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.live.tweets.application.ports.TweetsGenerateUseCase;
import pl.sztukakodu.live.tweets.application.ports.TweetsQueryUseCase;
import pl.sztukakodu.live.tweets.db.TweetsRepository;
import pl.sztukakodu.live.tweets.domain.Tweet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
class TweetsService implements TweetsQueryUseCase, TweetsGenerateUseCase {

    private final Faker faker = new Faker();
    private final TweetsRepository repository;

    @Override
    public List<Tweet> fetchAll() {
        return repository.findAll();
    }

    @Override
    public void generate(Long size) {
        for (int i = 0; i < size; i++) {
            Tweet tweet = new Tweet(
                faker.name().username(),
                faker.backToTheFuture().quote(),
                toLocalDateTime(faker.date().past(10, TimeUnit.DAYS))
            );
            repository.save(tweet);
        }
    }

    @Override
    public void clean() {
        repository.deleteAll();
    }

    private LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
