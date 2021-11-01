package pl.sztukakodu.concurrency;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.math.BigDecimal;

@AllArgsConstructor
public class RetriableCurrencyRate implements CurrencyRate {
    private final CurrencyRate origin;
    private final Sleeper sleeper;
    private int retriesLimit;

    @Override
    @SneakyThrows
    public BigDecimal rate(String from, String to) {
        BigDecimal rate = origin.rate(from, to);
        int retries = 0;
        while (rate == null && retries < retriesLimit) {
            sleeper.sleep(1_000);
            rate = origin.rate(from, to);
            ++retries;
        }
        return rate;
    }
}
