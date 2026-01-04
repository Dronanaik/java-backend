package com.transaction.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Service implementation for Currency Conversion
 * Feature 3: Currency Conversion with Real-time Exchange Rates
 */
@Service
public class CurrencyService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    // Exchange Rate CRUD
    public List<ExchangeRate> getAllRates() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate getRateById(Long id) {
        return exchangeRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exchange rate not found with id: " + id));
    }

    public ExchangeRate createOrUpdateRate(ExchangeRate rate) {
        return exchangeRateRepository.save(rate);
    }

    public void deleteRate(Long id) {
        exchangeRateRepository.deleteById(id);
    }

    // Feature 3: Currency Conversion
    public BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        BigDecimal rate = getLatestExchangeRate(fromCurrency, toCurrency);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLatestExchangeRate(String fromCurrency, String toCurrency) {
        List<ExchangeRate> rates = exchangeRateRepository.findLatestRate(fromCurrency, toCurrency);

        if (rates.isEmpty()) {
            throw new RuntimeException("Exchange rate not found for " + fromCurrency + " to " + toCurrency);
        }

        return rates.get(0).getRate();
    }

    public ExchangeRate getExchangeRatePair(String fromCurrency, String toCurrency) {
        return exchangeRateRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency)
                .orElseThrow(() -> new RuntimeException(
                        "Exchange rate not found for " + fromCurrency + " to " + toCurrency));
    }
}
