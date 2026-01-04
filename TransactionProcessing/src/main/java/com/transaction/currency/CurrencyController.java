package com.transaction.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller for Currency Conversion operations
 */
@RestController
@RequestMapping("/api/currency")
@CrossOrigin(origins = "*")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public ResponseEntity<List<ExchangeRate>> getAllRates() {
        return ResponseEntity.ok(currencyService.getAllRates());
    }

    @GetMapping("/rates/{id}")
    public ResponseEntity<ExchangeRate> getRateById(@PathVariable Long id) {
        return ResponseEntity.ok(currencyService.getRateById(id));
    }

    @PostMapping("/rates")
    public ResponseEntity<ExchangeRate> createOrUpdateRate(@RequestBody ExchangeRate rate) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(currencyService.createOrUpdateRate(rate));
    }

    @DeleteMapping("/rates/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable Long id) {
        currencyService.deleteRate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/convert")
    public ResponseEntity<Map<String, Object>> convertCurrency(
            @RequestParam BigDecimal amount,
            @RequestParam String from,
            @RequestParam String to) {

        BigDecimal convertedAmount = currencyService.convertCurrency(amount, from, to);
        BigDecimal rate = currencyService.getLatestExchangeRate(from, to);

        Map<String, Object> response = new HashMap<>();
        response.put("originalAmount", amount);
        response.put("fromCurrency", from);
        response.put("toCurrency", to);
        response.put("exchangeRate", rate);
        response.put("convertedAmount", convertedAmount);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/rate")
    public ResponseEntity<Map<String, Object>> getExchangeRate(
            @RequestParam String from,
            @RequestParam String to) {

        BigDecimal rate = currencyService.getLatestExchangeRate(from, to);

        Map<String, Object> response = new HashMap<>();
        response.put("fromCurrency", from);
        response.put("toCurrency", to);
        response.put("rate", rate);

        return ResponseEntity.ok(response);
    }
}
