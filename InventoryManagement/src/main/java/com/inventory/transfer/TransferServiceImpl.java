package com.inventory.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getTransferById(Long id) {
        return transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfer not found with id: " + id));
    }

    @Override
    public Transfer getTransferByNumber(String transferNumber) {
        return transferRepository.findByTransferNumber(transferNumber)
                .orElseThrow(() -> new RuntimeException("Transfer not found with number: " + transferNumber));
    }

    @Override
    public List<Transfer> getTransfersByProduct(Long productId) {
        return transferRepository.findByProductId(productId);
    }

    @Override
    public List<Transfer> getTransfersByFromWarehouse(Long warehouseId) {
        return transferRepository.findByFromWarehouseId(warehouseId);
    }

    @Override
    public List<Transfer> getTransfersByToWarehouse(Long warehouseId) {
        return transferRepository.findByToWarehouseId(warehouseId);
    }

    @Override
    public List<Transfer> getTransfersByStatus(Transfer.TransferStatus status) {
        return transferRepository.findByStatus(status);
    }

    @Override
    public List<Transfer> getTransfersByDateRange(LocalDate startDate, LocalDate endDate) {
        return transferRepository.findByTransferDateBetween(startDate, endDate);
    }

    @Override
    public Transfer createTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer updateTransfer(Long id, Transfer transfer) {
        Transfer existing = getTransferById(id);
        existing.setTransferNumber(transfer.getTransferNumber());
        existing.setProduct(transfer.getProduct());
        existing.setFromWarehouse(transfer.getFromWarehouse());
        existing.setToWarehouse(transfer.getToWarehouse());
        existing.setQuantity(transfer.getQuantity());
        existing.setBatchNumber(transfer.getBatchNumber());
        existing.setTransferDate(transfer.getTransferDate());
        existing.setExpectedArrivalDate(transfer.getExpectedArrivalDate());
        existing.setActualArrivalDate(transfer.getActualArrivalDate());
        existing.setStatus(transfer.getStatus());
        existing.setInitiatedBy(transfer.getInitiatedBy());
        existing.setApprovedBy(transfer.getApprovedBy());
        existing.setReceivedBy(transfer.getReceivedBy());
        existing.setNotes(transfer.getNotes());
        existing.setReason(transfer.getReason());
        return transferRepository.save(existing);
    }

    @Override
    public void deleteTransfer(Long id) {
        transferRepository.deleteById(id);
    }
}
