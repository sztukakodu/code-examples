package pl.sztukakodu.concurrency;

import java.math.BigDecimal;

public interface CurrencyRate {
    BigDecimal rate(String from, String to);
}
