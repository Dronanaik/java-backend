package com.inventory.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
    }

    @Override
    public List<Stock> getStocksByProduct(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    @Override
    public List<Stock> getStocksByWarehouse(Long warehouseId) {
        return stockRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Stock> getStocksByProductAndWarehouse(Long productId, Long warehouseId) {
        return stockRepository.findByProductAndWarehouse(productId, warehouseId);
    }

    @Override
    public List<Stock> getExpiringStocks(LocalDate beforeDate) {
        return stockRepository.findExpiringBefore(beforeDate);
    }

    @Override
    public List<Stock> getLowStockItems() {
        return stockRepository.findLowStockItems();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = getStockById(id);
        existing.setProduct(stock.getProduct());
        existing.setWarehouse(stock.getWarehouse());
        existing.setQuantity(stock.getQuantity());
        existing.setBatchNumber(stock.getBatchNumber());
        existing.setLotNumber(stock.getLotNumber());
        existing.setExpiryDate(stock.getExpiryDate());
        existing.setManufacturingDate(stock.getManufacturingDate());
        existing.setValuationMethod(stock.getValuationMethod());
        return stockRepository.save(existing);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
