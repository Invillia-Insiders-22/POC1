package com.github.allanccruz.POC1.api.controller;

import com.github.allanccruz.POC1.api.entities.Customer;
import com.github.allanccruz.POC1.api.enums.DocumentType;
import com.github.allanccruz.POC1.api.repository.CustomerRepository;
import com.github.allanccruz.POC1.api.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CustomerController.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CustomerControllerTest {

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByIdTest() {
    }

    @Test
    void saveCustomerTest() {
    }

    @Test
    void getAllCustomersTest() throws Exception {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();

        customer1.setId(UUID.fromString("001cc1ce-0b05-43e7-b0bd-ec928f8a0f7b"));
        customer1.setName("Joao");
        customer1.setEmail("joao@mail.com");
        customer1.setDocument("001");
        customer1.setDocumentType(DocumentType.PF);
        customer1.setPhoneNumber("9111-2222");

        customers.add(customer1);

        when(customerService.findAll()).thenReturn(customers);

        MvcResult mvcResult = this.mockMvc.perform(get("/api/poc1/customers")).andReturn();

        String expected = "[{\"id\": \"001cc1ce-0b05-43e7-b0bd-ec928f8a0f7b\",\"name\": \"Joao\",\"email\": \"joao@mail.com\", \"phoneNumber\": \"9111-2222\", \"addresses\": []}]";

        assertEquals(200, mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    void deleteByIdTest() {
    }

    @Test
    void updateTest() {
    }

    @Test
    void getAllAddressByCustomerTest() {
    }
}