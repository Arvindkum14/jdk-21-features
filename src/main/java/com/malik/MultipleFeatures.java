package com.malik;

import java.util.*;
import java.util.concurrent.*;

public class MultipleFeatures {

    // Java 21: Record class for data model
    record Person(String name, int age) {}

    public static void main(String[] args) throws InterruptedException {
        // Java 21: Pattern matching for switch + Record pattern
        Object obj = new Person("Alice", 30);

        switch (obj) {
            case Person(String name, int age) when age >= 18 ->
                    System.out.printf("Matched an adult Person: %s (Age: %d)%n", name, age);
            case Person(String name, int age) -> {
                    System.out.printf("Matched a minor Person: %s (Age: %d)%n", name, age);
            }
            default -> System.out.printf("Unknown type: %s%n", obj.getClass().getSimpleName());
        }

        // Java 21: Sequenced collections (List now implements SequencedCollection)
        SequencedCollection<String> items = new ArrayList<>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        System.out.println("First item: " + items.getFirst());
        System.out.println("Last item: " + items.getLast());

        items.forEach(System.out::println);

        // Java 21: Virtual threads
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        try {
            List<Callable<Void>> tasks = List.of(
                    () -> {
                        System.out.println("Hello from thread 1: " + Thread.currentThread());
                        return null;
                    },
                    () -> {
                        System.out.println("Hello from thread 2: " + Thread.currentThread());
                        return null;
                    }
            );

            executor.invokeAll(tasks);
        } finally {
            executor.shutdown();
        }
    }
}
