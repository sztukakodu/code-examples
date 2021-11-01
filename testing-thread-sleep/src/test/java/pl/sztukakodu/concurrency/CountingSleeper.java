package pl.sztukakodu.concurrency;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CountingSleeper implements Sleeper {
    private final Sleeper origin;
    private long count = 0;

    @Override
    public void sleep(long millis) {
        count++;
        origin.sleep(millis);
    }

    public void reset() {
        count = 0;
    }

    public long count() {
        return count;
    }
}
