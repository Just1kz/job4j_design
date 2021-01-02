package ru.job4j.serialization.json;

import java.util.Arrays;

public class Student {
    private final boolean learn;
    private final int lastCourse;
    private final TrainingPlatform trainingPlatform;
    private final String[] directions;

    public Student(boolean learn, int lastCourse, TrainingPlatform trainingPlatform, String... directions) {
        this.learn = learn;
        this.lastCourse = lastCourse;
        this.trainingPlatform = trainingPlatform;
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "Student{"
                + "learn="
                + learn
                + ", lastCourse="
                + lastCourse
                +  ", trainingPlatform="
                + trainingPlatform
                +  ", directions=" + Arrays.toString(directions)
                +  '}';
    }
}
