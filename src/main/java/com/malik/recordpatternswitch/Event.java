package com.malik.recordpatternswitch;

sealed interface Event permits UserRegistered, PaymentMade, OrderShipped, UnknownEvent {}

record UserRegistered(String username, String email) implements Event {}
record PaymentMade(String transactionId, double amount) implements Event {}
record OrderShipped(String orderId, String destination) implements Event {}
record UnknownEvent(String description) implements Event {}

