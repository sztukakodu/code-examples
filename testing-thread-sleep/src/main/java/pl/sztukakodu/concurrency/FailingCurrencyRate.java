package pl.sztukakodu.concurrency;

import java.math.BigDecimal;

public class FailingCurrencyRate implements CurrencyRate {
    @Override
    public BigDecimal rate(String from, String to) {
        return null;
    }
}
