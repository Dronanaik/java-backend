package com.deal;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    private final DealService service;

    public DealController(DealService service) {
        this.service = service;
    }

    @PostMapping
    public Deal create(@RequestBody Deal deal) {
        return service.createDeal(deal);
    }

    @GetMapping("/{id}")
    public Deal get(@PathVariable Long id) {
        return service.getDeal(id);
    }

    @GetMapping
    public List<Deal> getAll() {
        return service.getAllDeals();
    }

    @PutMapping("/{id}")
    public Deal update(@PathVariable Long id, @RequestBody Deal deal) {
        return service.updateDeal(id, deal);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteDeal(id);
        return "Deal deleted successfully!";
    }
}
