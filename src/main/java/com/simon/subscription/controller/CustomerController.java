package com.simon.subscription.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simon.subscription.domain.Customer;
import com.simon.subscription.dto.request.CreateCustomerRequest;
import com.simon.subscription.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(
            request.email(),
            request.firstName(),
            request.lastName()
            );
    }

    @GetMapping
    public Customer getCustomer(@RequestParam UUID id) {
        return customerService.getCustomer(id);
    }
    

}
