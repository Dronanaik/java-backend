package com.transaction.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for ExchangeRate entity
 */
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

    List<ExchangeRate> findByEffectiveDateBefore(LocalDate date);

    @Query("SELECT e FROM ExchangeRate e WHERE e.fromCurrency = :from AND e.toCurrency = :to ORDER BY e.effectiveDate DESC")
    List<ExchangeRate> findLatestRate(@Param("from") String from, @Param("to") String to);
}
