package pl.sztukakodu.live.tweets.application.ports;

public interface TweetsGenerateUseCase {

    void generate(Long size);

    void clean();
}
