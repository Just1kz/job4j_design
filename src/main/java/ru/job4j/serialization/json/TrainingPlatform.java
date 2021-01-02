package ru.job4j.serialization.json;

public class TrainingPlatform {
    private final String name;

    public TrainingPlatform(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TrainingPlatform{"
                + "name='"
                + name
                + '\''
                + '}';
    }
}
