package com.simon.subscription.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simon.subscription.domain.Subscription;
import com.simon.subscription.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public Subscription createSubscription(
        @RequestParam UUID customerId,
        @RequestParam String planType) {

        return subscriptionService.createSubscription(customerId, planType);
    }    

}
