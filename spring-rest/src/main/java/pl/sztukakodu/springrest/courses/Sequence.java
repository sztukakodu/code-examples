package pl.sztukakodu.springrest.courses;

import java.util.concurrent.atomic.AtomicLong;

class Sequence {
    private final AtomicLong value;

    public Sequence(Long initial) {
        this.value = new AtomicLong(initial);
    }

    public Sequence() {
        this(0L);
    }

    public long next() {
        return value.incrementAndGet();
    }

    public long current() {
        return value.get();
    }
}
