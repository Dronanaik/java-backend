package com.inventory.transfer;

import java.time.LocalDate;
import java.util.List;

public interface TransferService {
    List<Transfer> getAllTransfers();

    Transfer getTransferById(Long id);

    Transfer getTransferByNumber(String transferNumber);

    List<Transfer> getTransfersByProduct(Long productId);

    List<Transfer> getTransfersByFromWarehouse(Long warehouseId);

    List<Transfer> getTransfersByToWarehouse(Long warehouseId);

    List<Transfer> getTransfersByStatus(Transfer.TransferStatus status);

    List<Transfer> getTransfersByDateRange(LocalDate startDate, LocalDate endDate);

    Transfer createTransfer(Transfer transfer);

    Transfer updateTransfer(Long id, Transfer transfer);

    void deleteTransfer(Long id);
}
