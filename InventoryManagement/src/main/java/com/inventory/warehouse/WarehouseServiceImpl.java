package com.inventory.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + id));
    }

    @Override
    public Warehouse getWarehouseByCode(String code) {
        return warehouseRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with code: " + code));
    }

    @Override
    public List<Warehouse> getActiveWarehouses() {
        return warehouseRepository.findByIsActive(true);
    }

    @Override
    public List<Warehouse> getWarehousesByCity(String city) {
        return warehouseRepository.findByCity(city);
    }

    @Override
    public List<Warehouse> searchWarehousesByName(String name) {
        return warehouseRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse existing = getWarehouseById(id);
        existing.setCode(warehouse.getCode());
        existing.setName(warehouse.getName());
        existing.setAddress(warehouse.getAddress());
        existing.setCity(warehouse.getCity());
        existing.setState(warehouse.getState());
        existing.setZipCode(warehouse.getZipCode());
        existing.setCountry(warehouse.getCountry());
        existing.setContactPerson(warehouse.getContactPerson());
        existing.setContactPhone(warehouse.getContactPhone());
        existing.setContactEmail(warehouse.getContactEmail());
        existing.setCapacity(warehouse.getCapacity());
        existing.setIsActive(warehouse.getIsActive());
        return warehouseRepository.save(existing);
    }

    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
