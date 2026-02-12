package com.simon.subscription.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RiskAssessedConsumer {

    @KafkaListener(
        topics = "usage-topic",
        groupId = "subscription-service"
    )
    public void consumeRiskAssessed(String msg) {
        // TODO: Process the message and update the subscription usage accordingly
        System.out.println("Received risk-assessed msg: " + msg);
    }
}