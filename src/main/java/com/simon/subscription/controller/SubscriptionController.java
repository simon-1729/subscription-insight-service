package com.simon.subscription.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.subscription.dto.request.CreateSubscriptionRequest;
import com.simon.subscription.dto.response.SubscriptionResponse;
import com.simon.subscription.service.SubscriptionService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public SubscriptionResponse createSubscription(@RequestBody 
        CreateSubscriptionRequest request) {

        return subscriptionService.createSubscription(
            request.customerId(), 
            request.planType()
        );
    }      

}
