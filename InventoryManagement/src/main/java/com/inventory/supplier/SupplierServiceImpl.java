package com.inventory.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    @Override
    public Supplier getSupplierByCode(String code) {
        return supplierRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Supplier not found with code: " + code));
    }

    @Override
    public List<Supplier> getActiveSuppliers() {
        return supplierRepository.findByIsActive(true);
    }

    @Override
    public List<Supplier> searchSuppliersByName(String name) {
        return supplierRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Supplier> getSuppliersByRating(Integer rating) {
        return supplierRepository.findByRating(rating);
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existing = getSupplierById(id);
        existing.setCode(supplier.getCode());
        existing.setName(supplier.getName());
        existing.setContactPerson(supplier.getContactPerson());
        existing.setEmail(supplier.getEmail());
        existing.setPhone(supplier.getPhone());
        existing.setMobile(supplier.getMobile());
        existing.setAddress(supplier.getAddress());
        existing.setCity(supplier.getCity());
        existing.setState(supplier.getState());
        existing.setZipCode(supplier.getZipCode());
        existing.setCountry(supplier.getCountry());
        existing.setTaxId(supplier.getTaxId());
        existing.setPaymentTerms(supplier.getPaymentTerms());
        existing.setCreditLimit(supplier.getCreditLimit());
        existing.setRating(supplier.getRating());
        existing.setIsActive(supplier.getIsActive());
        existing.setNotes(supplier.getNotes());
        return supplierRepository.save(existing);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
