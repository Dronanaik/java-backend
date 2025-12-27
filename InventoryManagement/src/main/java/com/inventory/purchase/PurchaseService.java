package com.inventory.purchase;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();

    Purchase getPurchaseById(Long id);

    Purchase getPurchaseByOrderNumber(String purchaseOrderNumber);

    List<Purchase> getPurchasesBySupplier(Long supplierId);

    List<Purchase> getPurchasesByProduct(Long productId);

    List<Purchase> getPurchasesByWarehouse(Long warehouseId);

    List<Purchase> getPurchasesByStatus(Purchase.PurchaseStatus status);

    List<Purchase> getPurchasesByDateRange(LocalDate startDate, LocalDate endDate);

    Purchase createPurchase(Purchase purchase);

    Purchase updatePurchase(Long id, Purchase purchase);

    void deletePurchase(Long id);
}
