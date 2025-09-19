/*
We'll simulate a small application that:
Makes multiple "fake API calls" (simulated by Thread.sleep)
Uses virtual threads for lightweight concurrency
Collects and prints the results
Measures the total time taken — to show how efficient virtual threads are
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
