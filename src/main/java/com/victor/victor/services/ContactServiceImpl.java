package com.victor.victor.services;

import com.victor.victor.models.Contact;
import com.victor.victor.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> searchContacts(String firstName, String lastName) {
        return contactRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}