/**
* Feature 6: Scoped Values (JEP 446) — 🧪 Preview in Java 21
What is it?
Scoped Values provide a structured, safer alternative to ThreadLocal, allowing you to share immutable data across multiple threads, especially virtual threads, without the pitfalls of traditional thread-local storage.

Why use Scoped Values?
Designed for virtual threads and structured concurrency.
Provide immutable context that flows with thread execution.
Safer and more efficient than ThreadLocal because they avoid memory leaks and are designed for concurrency.
Real-World Example: Passing user context across async tasks
Imagine you have a web app that tracks a user ID for logging and auditing across multiple service calls running on different threads:
* Use Case: Request tracing, security context, logging context, transaction IDs.
* ------------But the final released versions of JDK 21 (including your 21.0.8 LTS build) do NOT include ScopedValue class.
* */
package com.malik.scopedvalues;

public class ThreadLocalExample {
    private static final ThreadLocal<String> USER = new ThreadLocal<>();

    public static void main(String[] args) {
        USER.set("alice");

        Runnable task = () -> System.out.println("User: " + USER.get());

        task.run();
    }
}


