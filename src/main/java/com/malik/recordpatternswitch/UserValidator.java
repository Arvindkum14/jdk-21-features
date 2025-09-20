/**
Record patterns make it easier to deconstruct record objects when using pattern matching, e.g., in if, switch, etc. This improves readability and avoids boilerplate code.
Real-World Example: Data validation in a web controller
Use Case: Clean code in domain validation, DTO processing, etc.
* */
package com.malik.recordpatternswitch;

public class UserValidator {

    // Define the record
    record User(String name, int age) {}

    // Method to validate user age
    public void validateUser(Object obj) {
        if (obj instanceof User(String name, int age)) {
            if (age >= 18) {
                System.out.println(name + " is an adult.");
            } else {
                System.out.println(name + " is a minor.");
            }
        } else {
            System.out.println("Object is not a User.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        UserValidator validator = new UserValidator();

        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 15);
        String notAUser = "Not a user";

        validator.validateUser(user1);     // Alice is an adult.
        validator.validateUser(user2);     // Bob is a minor.
        validator.validateUser(notAUser);  // Object is not a User.
    }
}

