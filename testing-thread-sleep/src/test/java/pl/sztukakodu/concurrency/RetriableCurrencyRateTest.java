package pl.sztukakodu.concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RetriableCurrencyRateTest {

    int retriesLimit = 3;
    CountingSleeper sleeper = new CountingSleeper(
        new NoopSleeper()
    );
    RetriableCurrencyRate sut = new RetriableCurrencyRate(
        new FailingCurrencyRate(),
        sleeper,
        retriesLimit
    );

    @Test
    public void shouldRetry3Times() {
        // when
        BigDecimal rate = sut.rate("usd", "pln");

        // then
        assertNull(rate);
        assertEquals(retriesLimit, sleeper.count());
    }

}