package ru.job4j.concurrent;

import java.util.Objects;

public class UserEmailNotification {
    private final String name;
    private final String email;

    public UserEmailNotification(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEmailNotification that = (UserEmailNotification) o;
        return Objects.equals(name, that.name)
                && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "UserEmailNotification{"
                + "name='"
                + name
                + '\''
                + ", email='"
                + email
                + '\''
                + '}';
    }
}
