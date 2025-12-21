package com.contact;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return service.createContact(contact);
    }

    @GetMapping("/{id}")
    public Contact get(@PathVariable Long id) {
        return service.getContact(id);
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAllContacts();
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteContact(id);
        return "Contact deleted successfully!";
    }
}
