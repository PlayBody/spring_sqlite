package com.victor.victor.services;


import com.victor.victor.models.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> searchContacts(String firstName, String lastName);
    void updateContact(Contact contact);
    void deleteContact(Long id);
}