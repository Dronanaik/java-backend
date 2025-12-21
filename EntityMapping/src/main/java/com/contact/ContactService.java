package com.contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);

    Contact getContact(Long id);

    List<Contact> getAllContacts();

    Contact updateContact(Long id, Contact updated);

    void deleteContact(Long id);
}
