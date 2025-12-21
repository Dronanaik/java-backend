package com.deal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository repository;

    public DealServiceImpl(DealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Deal createDeal(Deal deal) {
        return repository.save(deal);
    }

    @Override
    public Deal getDeal(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deal not found with id: " + id));
    }

    @Override
    public List<Deal> getAllDeals() {
        return repository.findAll();
    }

    @Override
    public Deal updateDeal(Long id, Deal updated) {
        Deal existing = getDeal(id);

        existing.setDealName(updated.getDealName());
        existing.setValue(updated.getValue());
        existing.setStage(updated.getStage());
        existing.setCustomer(updated.getCustomer());

        return repository.save(existing);
    }

    @Override
    public void deleteDeal(Long id) {
        repository.deleteById(id);
    }
}
