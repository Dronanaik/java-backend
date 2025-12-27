package com.inventory.stock;

import java.time.LocalDate;
import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id);

    List<Stock> getStocksByProduct(Long productId);

    List<Stock> getStocksByWarehouse(Long warehouseId);

    List<Stock> getStocksByProductAndWarehouse(Long productId, Long warehouseId);

    List<Stock> getExpiringStocks(LocalDate beforeDate);

    List<Stock> getLowStockItems();

    Stock createStock(Stock stock);

    Stock updateStock(Long id, Stock stock);

    void deleteStock(Long id);
}
