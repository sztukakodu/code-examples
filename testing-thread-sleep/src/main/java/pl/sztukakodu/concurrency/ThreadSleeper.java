package pl.sztukakodu.concurrency;

import lombok.SneakyThrows;

public class ThreadSleeper implements Sleeper {
    @SneakyThrows
    @Override
    public void sleep(long millis) {
        Thread.sleep(millis);
    }
}
