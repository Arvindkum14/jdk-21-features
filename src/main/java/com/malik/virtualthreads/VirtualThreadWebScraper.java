/**
Real-world Example: Concurrent Web Scraper Using Virtual Threads
Scenario:
You want to download the HTML content from multiple websites in parallel, but without the complexity of asynchronous callbacks or reactive streams.
*/
package com.malik.virtualthreads;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadWebScraper {

    public static void main(String[] args) throws InterruptedException {
        List<String> urls = List.of(
                "https://www.example.com",
                "https://www.wikipedia.org",
                "https://www.openai.com",
                "https://www.oracle.com"
        );

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        try {
            List<Callable<String>> tasks = urls.stream()
                    .map(url -> (Callable<String>) () -> fetchUrlContent(url))
                    .toList();

            List<Future<String>> futures = executor.invokeAll(tasks);

            for (int i = 0; i < urls.size(); i++) {
                try {
                    String content = futures.get(i).get();
                    System.out.printf("Fetched %d characters from %s%n", content.length(), urls.get(i));
                } catch (ExecutionException e) {
                    System.err.printf("Failed to fetch from %s: %s%n", urls.get(i), e.getCause());
                }
            }
        } finally {
            executor.shutdown();
        }
    }

    private static String fetchUrlContent(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        System.out.printf("Fetching %s on thread %s%n", url, Thread.currentThread());

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

