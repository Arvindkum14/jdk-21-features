/**
3. Using TreeSet to Store Sorted Task Priorities
🧠 Use Case: Manage tasks sorted by priority (automatically ordered)
* */
package com.malik.sequencedcollections;

import java.util.SequencedCollection;
import java.util.TreeSet;

public class TaskManager {
    public static void main(String[] args) {
        // Tasks sorted by priority (lower = higher priority)
        SequencedCollection<String> tasks = new TreeSet<>();

        tasks.add("3-Finish report");
        tasks.add("1-Reply to client");
        tasks.add("2-Review PR");

        // Show highest and lowest priority
        System.out.println("Highest Priority Task: " + tasks.getFirst());
        System.out.println("Lowest Priority Task: " + tasks.getLast());

        // Show all tasks in reverse priority
        System.out.println("Tasks (reverse priority): " + tasks.reversed());
    }
}

