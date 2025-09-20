/**
Sure! Here's an extended version of your virtual threads web scraper that includes:
Timeouts on each HTTP request
Robust error handling for failures
Structured concurrency using Java 21's StructuredTaskScope to manage threads cleanly
 */
package com.malik.virtualthreads;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadWebScraperStructured {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> urls = List.of(
                "https://www.example.com",
                "https://www.wikipedia.org",
                "https://www.openai.com",
                "https://thisurldoesnotexist.fake" // Intentional invalid URL for testing error handling
        );

        // Use Java 21 virtual thread executor
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            // Fork a virtual thread task for each URL
            List<StructuredTaskScope.Subtask<String>> tasks = urls.stream()
                    .map(url -> scope.fork(() -> fetchUrlContent(url)))
                    .toList();

            // Wait for all tasks to finish or fail
            scope.join();
            scope.throwIfFailed();

            // Process results
            for (int i = 0; i < urls.size(); i++) {
                String content = tasks.get(i).get();
                System.out.printf("Fetched %d characters from %s%n", content.length(), urls.get(i));
            }
        } catch (ExecutionException e) {
            System.err.println("One or more tasks failed: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }

    private static String fetchUrlContent(String url) throws IOException, InterruptedException, TimeoutException {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3)) // Connection timeout
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(5)) // Request timeout
                .GET()
                .build();

        System.out.printf("Fetching %s on thread %s%n", url, Thread.currentThread());

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode >= 200 && statusCode < 300) {
                return response.body();
            } else {
                throw new IOException("Unexpected status code: " + statusCode);
            }
        } catch (HttpTimeoutException e) {
            throw new TimeoutException("Timeout while fetching: " + url);
        }
    }
}
