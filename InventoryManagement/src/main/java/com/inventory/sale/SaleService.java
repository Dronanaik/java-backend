package com.inventory.sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();

    Sale getSaleById(Long id);

    Sale getSaleByOrderNumber(String salesOrderNumber);

    List<Sale> getSalesByProduct(Long productId);

    List<Sale> getSalesByWarehouse(Long warehouseId);

    List<Sale> getSalesByStatus(Sale.SaleStatus status);

    List<Sale> getSalesByPaymentStatus(Sale.PaymentStatus paymentStatus);

    List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate);

    List<Sale> searchSalesByCustomerName(String customerName);

    Sale createSale(Sale sale);

    Sale updateSale(Long id, Sale sale);

    void deleteSale(Long id);
}
