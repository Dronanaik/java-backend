package com.inventory.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
    }

    @Override
    public Purchase getPurchaseByOrderNumber(String purchaseOrderNumber) {
        return purchaseRepository.findByPurchaseOrderNumber(purchaseOrderNumber)
                .orElseThrow(
                        () -> new RuntimeException("Purchase not found with order number: " + purchaseOrderNumber));
    }

    @Override
    public List<Purchase> getPurchasesBySupplier(Long supplierId) {
        return purchaseRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<Purchase> getPurchasesByProduct(Long productId) {
        return purchaseRepository.findByProductId(productId);
    }

    @Override
    public List<Purchase> getPurchasesByWarehouse(Long warehouseId) {
        return purchaseRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Purchase> getPurchasesByStatus(Purchase.PurchaseStatus status) {
        return purchaseRepository.findByStatus(status);
    }

    @Override
    public List<Purchase> getPurchasesByDateRange(LocalDate startDate, LocalDate endDate) {
        return purchaseRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Long id, Purchase purchase) {
        Purchase existing = getPurchaseById(id);
        existing.setPurchaseOrderNumber(purchase.getPurchaseOrderNumber());
        existing.setSupplier(purchase.getSupplier());
        existing.setProduct(purchase.getProduct());
        existing.setWarehouse(purchase.getWarehouse());
        existing.setQuantity(purchase.getQuantity());
        existing.setUnitPrice(purchase.getUnitPrice());
        existing.setBatchNumber(purchase.getBatchNumber());
        existing.setExpiryDate(purchase.getExpiryDate());
        existing.setManufacturingDate(purchase.getManufacturingDate());
        existing.setOrderDate(purchase.getOrderDate());
        existing.setExpectedDeliveryDate(purchase.getExpectedDeliveryDate());
        existing.setActualDeliveryDate(purchase.getActualDeliveryDate());
        existing.setStatus(purchase.getStatus());
        existing.setNotes(purchase.getNotes());
        return purchaseRepository.save(existing);
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }
}
