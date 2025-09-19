package com.malik.sequencedcollections;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class RecentActivityTracker {

    private final SequencedCollection<String> activities;

    public RecentActivityTracker() {
        this.activities = new LinkedList<>();
    }

    public void addActivity(String activity) {
        activities.addLast(activity); // Adds to the end (most recent)
    }

    public String getMostRecentActivity() {
        return activities.getLast(); // Most recent activity
    }

    public String getOldestActivity() {
        return activities.getFirst(); // Oldest activity
    }

    public void showActivitiesNewestFirst() {
        System.out.println("📜 Recent Activities (newest to oldest):");
        for (String activity : activities.reversed()) {
            System.out.println(" - " + activity);
        }
    }

    public void showActivitiesOldestFirst() {
        System.out.println("📜 Recent Activities (oldest to newest):");
        for (String activity : activities) {
            System.out.println(" - " + activity);
        }
    }
}

