package com.deal;

import java.util.List;

public interface DealService {

    Deal createDeal(Deal deal);

    Deal getDeal(Long id);

    List<Deal> getAllDeals();

    Deal updateDeal(Long id, Deal updated);

    void deleteDeal(Long id);
}
