/*
* Real-World Scenario: Event Processing System
🔹 Use Case:
Imagine you're building an event processing system for an application. Each event type (e.g., UserRegistered, PaymentMade, OrderShipped) has different data, and you want to handle them polymorphically using switch with pattern matching.
*/
package com.malik.recordpatternswitch;

import java.util.List;

public class MainEvent {
    public static void main(String[] args) {
        List<Event> events = List.of(
                new UserRegistered("alice", "alice@example.com"),
                new PaymentMade("TX123", 99.99),
                new PaymentMade("TX124", 2500.00),
                new OrderShipped("ORD789", "New York"),
                new UnknownEvent("Legacy format event")
        );

        events.forEach(EventProcessor::processEvent);
    }
}

