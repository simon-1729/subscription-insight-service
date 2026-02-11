package com.simon.subscription.dto.request;


public record CreateCustomerRequest(
        String email,
        String firstName,
        String lastName
) {}