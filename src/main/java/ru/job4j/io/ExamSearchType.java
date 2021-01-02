package ru.job4j.io;

public enum ExamSearchType {
    M("-m"), F("-f"), R("-r");

    private final String name;

    ExamSearchType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
