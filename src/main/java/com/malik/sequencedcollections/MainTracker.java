/*
Java 21 introduced the new SequencedCollection interface — a major usability enhancement!

🔥 In Java 21, List, Deque, LinkedHashSet, TreeSet, etc. now implement SequencedCollection, which guarantees a defined iteration order and provides new methods to access elements from both ends of the collection.

✅ Real-World Example: Recent Activity Tracker (like Browser History)
🔹 Use Case:
Imagine building a "recent activity tracker", similar to a browser history or recent documents list. You want:

Insertions at the end (most recent activity)
Easy access to the first and last activities
Reverse iteration (e.g., display newest to oldest)
With SequencedCollection, this becomes clean and elegant.
*/
package com.malik.sequencedcollections;

public class MainTracker {
    public static void main(String[] args) {
        RecentActivityTracker tracker = new RecentActivityTracker();

        tracker.addActivity("Opened email");
        tracker.addActivity("Edited document");
        tracker.addActivity("Pushed code to GitHub");
        tracker.addActivity("Deployed to production");

        System.out.println("Most recent: " + tracker.getMostRecentActivity());
        System.out.println("Oldest: " + tracker.getOldestActivity());
        System.out.println();

        tracker.showActivitiesNewestFirst();
        System.out.println();
        tracker.showActivitiesOldestFirst();
    }
}

