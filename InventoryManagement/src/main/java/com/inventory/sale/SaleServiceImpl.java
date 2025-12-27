package com.inventory.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
    }

    @Override
    public Sale getSaleByOrderNumber(String salesOrderNumber) {
        return saleRepository.findBySalesOrderNumber(salesOrderNumber)
                .orElseThrow(() -> new RuntimeException("Sale not found with order number: " + salesOrderNumber));
    }

    @Override
    public List<Sale> getSalesByProduct(Long productId) {
        return saleRepository.findByProductId(productId);
    }

    @Override
    public List<Sale> getSalesByWarehouse(Long warehouseId) {
        return saleRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Sale> getSalesByStatus(Sale.SaleStatus status) {
        return saleRepository.findByStatus(status);
    }

    @Override
    public List<Sale> getSalesByPaymentStatus(Sale.PaymentStatus paymentStatus) {
        return saleRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        return saleRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<Sale> searchSalesByCustomerName(String customerName) {
        return saleRepository.findByCustomerNameContainingIgnoreCase(customerName);
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        Sale existing = getSaleById(id);
        existing.setSalesOrderNumber(sale.getSalesOrderNumber());
        existing.setProduct(sale.getProduct());
        existing.setWarehouse(sale.getWarehouse());
        existing.setQuantity(sale.getQuantity());
        existing.setUnitPrice(sale.getUnitPrice());
        existing.setDiscount(sale.getDiscount());
        existing.setTax(sale.getTax());
        existing.setCustomerName(sale.getCustomerName());
        existing.setCustomerEmail(sale.getCustomerEmail());
        existing.setCustomerPhone(sale.getCustomerPhone());
        existing.setShippingAddress(sale.getShippingAddress());
        existing.setOrderDate(sale.getOrderDate());
        existing.setDeliveryDate(sale.getDeliveryDate());
        existing.setStatus(sale.getStatus());
        existing.setPaymentStatus(sale.getPaymentStatus());
        existing.setPaymentMethod(sale.getPaymentMethod());
        existing.setNotes(sale.getNotes());
        return saleRepository.save(existing);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
