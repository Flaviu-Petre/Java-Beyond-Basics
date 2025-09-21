package models;

import java.util.Optional;

public record Person (String name, Optional<Integer> age, String email) {

    public Person {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }

    public Person(String name, int age, String email) {
        this(name, Optional.of(age), email);
    }

    public Person(String name, String email) {
        this(name, Optional.empty(), email);
    }
}
