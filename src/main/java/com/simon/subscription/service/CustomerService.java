package com.simon.subscription.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simon.subscription.domain.Customer;
import com.simon.subscription.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(String email, String firstName, String lastName) {
        Customer customer = Customer.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .createdAt(LocalDateTime.now())
                .build();

        return customerRepository.save(customer);
    }

    public Customer getCustomer(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
