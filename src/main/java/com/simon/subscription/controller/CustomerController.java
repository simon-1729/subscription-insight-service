package com.simon.subscription.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simon.subscription.domain.Customer;
import com.simon.subscription.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestParam String email, @RequestParam String firstName, 
        @RequestParam String lastName) { 
        return customerService.createCustomer(email, firstName, lastName);     
        
    }

    @GetMapping
    public Customer getCustomer(@RequestParam UUID id) {
        return customerService.getCustomer(id);
    }
    

}
