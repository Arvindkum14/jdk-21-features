/**
Feature 5: Virtual Threads (JEP 444) —Final in Java 21
What is it?
Virtual Threads are lightweight threads managed by the Java runtime rather than the OS. They allow massive concurrency with minimal resource overhead, making it easy to write highly scalable concurrent applications using familiar threading APIs.

Why is it a big deal?
Traditional Java threads are expensive and limited in number due to OS thread constraints. Virtual Threads let you create millions of concurrent tasks efficiently.

Real-World Example: High-concurrency web server handling thousands of requests
Imagine a server that needs to handle thousands of simultaneous client connections without complex async code:
Use Case: Web servers, microservices, messaging consumers, parallel batch jobs.
*/
package com.malik.virtualthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadDemo {

    // Simulate an API call
    public static String fetchData(String source) throws InterruptedException {
        System.out.printf("Fetching from %s on thread: %s%n", source, Thread.currentThread());
        Thread.sleep(10000); // Simulate delay
        return "Data from " + source;
    }

    public static void main(String[] args) throws InterruptedException {
        // Start timing
        Instant start = Instant.now();

        // Use Java 21's virtual thread executor
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        try {
            // Define tasks
            List<Callable<String>> tasks = List.of(
                    () -> fetchData("Service A"),
                    () -> fetchData("Service B"),
                    () -> fetchData("Service C"),
                    () -> fetchData("Service D"),
                    () -> fetchData("Service E")
            );

            // Submit tasks
            List<Future<String>> results = executor.invokeAll(tasks);

            // Print results
            for (Future<String> future : results) {
                try {
                    System.out.println("Result: " + future.get());
                } catch (ExecutionException e) {
                    System.err.println("Error: " + e.getCause());
                }
            }
        } finally {
            executor.shutdown(); // Clean up
        }

        // End timing
        Instant end = Instant.now();
        System.out.println("Total time: " + Duration.between(start, end).toMillis() + "ms");
    }
}
