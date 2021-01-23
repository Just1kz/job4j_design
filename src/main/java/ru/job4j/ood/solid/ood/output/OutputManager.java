package ru.job4j.ood.solid.ood.output;

public interface OutputManager {
    default void println(String x) {
        System.out.println(x);
    }

    void printTable(String[][] x);
}
