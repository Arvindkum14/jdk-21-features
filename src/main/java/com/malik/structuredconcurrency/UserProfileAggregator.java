/**
 * Scenario:
 * Imagine you’re building a service that aggregates user profile info from 3 different APIs (profile, posts, and friends). Each API call can be done concurrently, but you want to wait for all to finish or fail fast if any fails.
 */
package com.malik.structuredconcurrency;

import java.util.concurrent.*;
import java.util.List;

public class UserProfileAggregator {

    public static void main(String[] args) throws Exception {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            var profile = scope.fork(() -> fetchUserProfile());
            var posts = scope.fork(() -> fetchUserPosts());
            var friends = scope.fork(() -> fetchUserFriends());

            scope.join();           // Wait for all tasks to complete
            scope.throwIfFailed();  // Fail fast if any task failed

            // Aggregate results
            UserProfile userProfile = new UserProfile(
                    profile.get(),
                    posts.get(),
                    friends.get()
            );

            System.out.println(userProfile);
        }
    }

    static String fetchUserProfile() throws InterruptedException {
        Thread.sleep(700); // Simulate API delay
        return "Profile{name='Alice', age=30}";
    }

    static List<String> fetchUserPosts() throws InterruptedException {
        Thread.sleep(900); // Simulate API delay
        return List.of("Post1", "Post2", "Post3");
    }

    static List<String> fetchUserFriends() throws InterruptedException {
        Thread.sleep(800); // Simulate API delay
        return List.of("Bob", "Carol", "Dave");
    }

    record UserProfile(String profileInfo, List<String> posts, List<String> friends) {
        @Override
        public String toString() {
            return "UserProfile{\n" +
                    "  Profile = " + profileInfo + ",\n" +
                    "  Posts = " + posts + ",\n" +
                    "  Friends = " + friends + "\n" +
                    '}';
        }
    }
}

