/*
Java 21's virtual threads are extremely lightweight — you can create thousands (even millions) without overwhelming the JVM, unlike platform threads.
Example: Launching 10,000 virtual threads
*/
package com.malik.virtualthreads;

public class VirtualThreadMassiveDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10_000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int id = i;
            threads[i] = Thread.startVirtualThread(() -> {
                System.out.printf("Hello from virtual thread %d (thread: %s)%n", id, Thread.currentThread());
                try {
                    Thread.sleep(100); // Simulate some blocking I/O
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All virtual threads finished.");
    }
}
