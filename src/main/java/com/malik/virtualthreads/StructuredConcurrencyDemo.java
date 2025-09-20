/**
Part 2: Using Structured Concurrency (JEP 453)
Structured concurrency is about scoping lifetimes of threads — when a method starts multiple subtasks (threads), those subtasks are grouped and awaited together
Java 21 adds this via StructuredTaskScope.
* */
package com.malik.virtualthreads;

import java.util.concurrent.*;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyDemo {

    static String fetchData(String service) throws InterruptedException {
        System.out.printf("Fetching from %s on %s%n", service, Thread.currentThread());
        Thread.sleep(1000); // simulate blocking I/O
        return "Data from " + service;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            StructuredTaskScope.Subtask<String> task1 = scope.fork(() -> fetchData("Service A"));
            StructuredTaskScope.Subtask<String> task2 = scope.fork(() -> fetchData("Service B"));

            scope.join();           // wait for all tasks to complete
            scope.throwIfFailed();  // throw if any task failed

            // Retrieve results
            String result1 = task1.get();
            String result2 = task2.get();

            System.out.println("Result 1: " + result1);
            System.out.println("Result 2: " + result2);
        }
    }
}

