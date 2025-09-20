/**
Feature 2: Pattern Matching for switch (JEP 441)
What is it?
Pattern Matching for switch allows you to use types and conditions directly in switch cases. This avoids verbose if-else blocks and makes control flow more expressive and type-safe.
Real-World Example: Processing different request types in a backend API

Imagine a system that processes different types of requests coming into a service. Each request is modeled as a class:
Use Case: Clean branching logic in controllers, message handlers, domain-driven design (DDD) services.
* */
package com.malik.recordpatternswitch;

public class RequestHandler {

    // Sealed interface with permitted types
    sealed interface Request permits LoginRequest, DataRequest {}

    // Record implementations
    record LoginRequest(String username, String password) implements Request {}
    record DataRequest(String dataType, String payload) implements Request {}

    // Method that handles different types of requests
    public void handleRequest(Request req) {
        switch (req) {
            case LoginRequest(String user, String pass) ->
                    System.out.println("Login attempt by " + user);

            case DataRequest(String type, String payload) when type.equals("JSON") ->
                    System.out.println("Processing JSON data: " + payload);

            case DataRequest(String type, String payload) ->
                    System.out.println("Unsupported data type: " + type);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        RequestHandler handler = new RequestHandler();

        Request login = new LoginRequest("alice", "secret");
        Request jsonData = new DataRequest("JSON", "{\"key\":\"value\"}");
        Request xmlData = new DataRequest("XML", "<key>value</key>");

        handler.handleRequest(login);     // Login attempt by alice
        handler.handleRequest(jsonData);  // Processing JSON data: {"key":"value"}
        handler.handleRequest(xmlData);   // Unsupported data type: XML
    }
}

