package com.victor.victor.controllers;

import com.victor.victor.models.Contact;
import com.victor.victor.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @GetMapping
    public List<Contact> searchContacts(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        return contactService.searchContacts(firstName, lastName);
    }

    @PutMapping
    public void updateContact(@RequestBody Contact contact) {
        contactService.updateContact(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}