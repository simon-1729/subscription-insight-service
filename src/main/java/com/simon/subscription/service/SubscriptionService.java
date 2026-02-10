package com.simon.subscription.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simon.subscription.domain.Customer;
import com.simon.subscription.domain.Subscription;
import com.simon.subscription.repository.CustomerRepository;
import com.simon.subscription.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final CustomerRepository customerRepository;

    public Subscription createSubscription(UUID customerId, String planType) {
        // Fetch the customer from the database
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Create a new subscription
        Subscription subscription = Subscription.builder()
                .customer(customer)
                .planType(planType)
                .status("ACTIVE")
                .startDate(LocalDate.now())
                .renewalDate(LocalDate.now().plusMonths(1))
                .build();

        // Save the subscription to the database
        return subscriptionRepository.save(subscription);
    }

}
