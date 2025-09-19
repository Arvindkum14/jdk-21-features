/*
1. Using Deque in a Browser History Navigation
🧠 Use Case: Browser history navigation with forward/backward logic
* */
package com.malik.sequencedcollections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.SequencedCollection;

public class BrowserHistory {
    public static void main(String[] args) {
        SequencedCollection<String> history = new LinkedList<>();

        // User navigates to some pages
        history.addLast("home.com");
        history.addLast("about.com");
        history.addLast("contact.com");

        System.out.println("Current Page: " + history.getLast()); // contact.com

        // User presses back button
        ((Deque<String>) history).removeLast(); // remove current
        System.out.println("Back to: " + history.getLast()); // about.com

        // Reverse the history (show from oldest to newest)
        System.out.println("History (oldest to newest): " + history.reversed());
    }
}

