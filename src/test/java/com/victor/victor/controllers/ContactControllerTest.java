package com.victor.victor.controllers;

import com.victor.victor.models.Contact;
import com.victor.victor.services.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ContactControllerTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

    @Test
    public void testCreateContact() throws Exception {
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setLastName("Doe");

        when(contactService.createContact(any(Contact.class))).thenReturn(contact);

        mockMvc.perform(post("/contacts")
                        .content("{ \"firstName\": \"John\", \"lastName\": \"Doe\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));

        verify(contactService).createContact(any(Contact.class));
    }

    @Test
    public void testSearchContacts() throws Exception {
        List<Contact> contacts = Arrays.asList(
                new Contact("John", "Doe", "john.doe@example.com", "1234567890"),
                new Contact("Jane", "Doe", "jane.doe@example.com", "9876543210")
        );

        when(contactService.searchContacts("John", "Doe")).thenReturn(contacts);

        mockMvc.perform(get("/contacts")
                        .param("firstName", "John")
                        .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[1].lastName").value("Doe"));

        verify(contactService).searchContacts("John", "Doe");
    }


//    @Test
//    public void testUpdateContact() throws Exception {
//        Contact existingContact = new Contact();
//        existingContact.setId(1L);
//        existingContact.setFirstName("John");
//        existingContact.setLastName("Doe");
//
//        mockMvc.perform(put("/contacts")
//                        .content("{ \"id\": 1, \"firstName\": \"John\", \"lastName\": \"Doe\" }")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.firstName").value("John"))
//                .andExpect(jsonPath("$.lastName").value("Doe"));
//
//        verify(contactService).updateContact(any(Contact.class));
//    }

    @Test
    public void testDeleteContact() throws Exception {
        Long contactId = 1L;

        mockMvc.perform(delete("/contacts/{id}", contactId))
                .andExpect(status().isOk());

        verify(contactService).deleteContact(contactId);
    }

}
