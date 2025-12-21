package com.contact;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact getContact(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public Contact updateContact(Long id, Contact updated) {
        Contact existing = getContact(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setCustomer(updated.getCustomer());
        return repository.save(existing);
    }

    @Override
    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
