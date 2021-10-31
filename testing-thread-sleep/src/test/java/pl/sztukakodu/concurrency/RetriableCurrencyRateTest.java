package pl.sztukakodu.concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RetriableCurrencyRateTest {

    RetriableCurrencyRate sut = new RetriableCurrencyRate(
        new FailingCurrencyRate()
    );

    @Test
    public void shouldRetry3Times() {
        // when
        BigDecimal rate = sut.rate("usd", "pln");

        // then
        assertNull(rate);
        // and 3 retries each after 100ms
    }

}