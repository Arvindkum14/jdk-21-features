/**
Feature 3: String Templates (JEP 430) — 🧪 Preview in Java 21
What is it?

String Templates introduce a new, concise, and safe way to embed expressions in strings, similar to template strings in other languages like JavaScript or Python.
This is much more readable than traditional string concatenation or String.format.
Real-World Example: Logging User Activity with Dynamic Data
Imagine you're building an audit logger for user actions:
Use Case: Logging, SQL queries, HTML generation, building messages, email templates, etc.
* */
package com.malik.stringtemplate;

public class Logger {
    public static void logUserAction(String username, String action, String ipAddress) {
        String message = """
            User "%s" performed "%s" from IP [%s]
            """.formatted(username, action, ipAddress);
        System.out.println(message);
    }

    public static void main(String[] args) {
        logUserAction("alice", "login", "192.168.0.1");
        logUserAction("bob", "upload", "10.0.0.5");
    }
}



