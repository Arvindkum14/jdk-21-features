/**
*Feature 7: Structured Concurrency (JEP 453) — Preview in Java 21
What is it?
Structured Concurrency introduces a new API to manage multiple concurrent tasks in a structured way, treating them as a single unit of work that starts and completes together.
This improves error handling, cancellation, and lifecycle management of concurrent tasks.

Why does it matter?
Traditionally, managing multiple threads or tasks involves complex boilerplate for error propagation, cancellation, and result aggregation. Structured Concurrency simplifies this.

Real-World Example: Parallel data fetch and processing
Suppose you want to fetch user details and order history in parallel, then combine results:
* Use Case: Microservices orchestration, parallel API calls, batch jobs.
* */
package com.malik.structuredconcurrency;

import java.util.concurrent.*;

public class StructuredConcurrencyExample {

    public static void main(String[] args) throws Exception {
        // StructuredTaskScope.ShutdownOnFailure automatically shuts down all subtasks if one fails
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            // Fork two subtasks
            StructuredTaskScope.Subtask<String> userDetails = scope.fork(() -> fetchUserDetails());
            StructuredTaskScope.Subtask<String> orderHistory = scope.fork(() -> fetchOrderHistory());

            // Wait for all subtasks to complete
            scope.join();

            // If any subtask failed, propagate the exception
            scope.throwIfFailed();

            // Retrieve results
            System.out.println("User Details: " + userDetails.get());
            System.out.println("Order History: " + orderHistory.get());
        }
    }

    // Simulates fetching user details with a delay
    static String fetchUserDetails() throws InterruptedException {
        Thread.sleep(1000);
        return "User: Alice";
    }

    // Simulates fetching order history with a delay
    static String fetchOrderHistory() throws InterruptedException {
        Thread.sleep(800);
        return "Orders: [Order1, Order2]";
    }
}

