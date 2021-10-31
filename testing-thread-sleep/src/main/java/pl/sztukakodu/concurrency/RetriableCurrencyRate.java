package pl.sztukakodu.concurrency;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.math.BigDecimal;

@AllArgsConstructor
public class RetriableCurrencyRate implements CurrencyRate {
    private final CurrencyRate origin;

    @Override
    @SneakyThrows
    public BigDecimal rate(String from, String to) {
        // retry 3 times after 1 second
        BigDecimal rate = origin.rate(from, to);
        int retries = 0;
        while(rate == null && retries < 3) {
            Thread.sleep(100);
            rate = origin.rate(from, to);
            ++retries;
        }
        return rate;
    }
}
