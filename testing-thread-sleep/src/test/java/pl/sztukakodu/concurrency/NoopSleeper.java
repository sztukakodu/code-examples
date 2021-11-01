package pl.sztukakodu.concurrency;

public class NoopSleeper implements Sleeper {
    @Override
    public void sleep(long millis) {
        System.out.println("Noop sleep :)");
    }
}
