package com.inventory.supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id);

    Supplier getSupplierByCode(String code);

    List<Supplier> getActiveSuppliers();

    List<Supplier> searchSuppliersByName(String name);

    List<Supplier> getSuppliersByRating(Integer rating);

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Long id, Supplier supplier);

    void deleteSupplier(Long id);
}
