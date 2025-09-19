package com.malik.recordpatternswitch;

public class EventProcessor {

    public static void processEvent(Event event) {
        String message = switch (event) {
            case UserRegistered(String username, String email) ->
                    "📨 New user registered: %s (%s)".formatted(username, email);

            case PaymentMade(String txnId, double amount) when amount > 1000 ->
                    "💰 High-value payment detected! ID: %s, Amount: %.2f".formatted(txnId, amount);

            case PaymentMade(String txnId, double amount) ->
                    "💳 Payment received: ID: %s, Amount: %.2f".formatted(txnId, amount);

            case OrderShipped(String orderId, String destination) ->
                    "🚚 Order shipped: ID: %s to %s".formatted(orderId, destination);

            case UnknownEvent(String description) ->
                    "❓ Unknown event received: " + description;

            default -> "⚠️ Unhandled event type: " + event;
        };

        System.out.println(message);
    }
}

