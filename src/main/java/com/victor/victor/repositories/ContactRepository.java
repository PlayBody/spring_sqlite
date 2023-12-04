package com.victor.victor.repositories;

import com.victor.victor.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByFirstNameOrLastName(String firstName, String lastName);
}