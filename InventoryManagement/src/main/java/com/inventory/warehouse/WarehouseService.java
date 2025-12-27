package com.inventory.warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> getAllWarehouses();

    Warehouse getWarehouseById(Long id);

    Warehouse getWarehouseByCode(String code);

    List<Warehouse> getActiveWarehouses();

    List<Warehouse> getWarehousesByCity(String city);

    List<Warehouse> searchWarehousesByName(String name);

    Warehouse createWarehouse(Warehouse warehouse);

    Warehouse updateWarehouse(Long id, Warehouse warehouse);

    void deleteWarehouse(Long id);
}
