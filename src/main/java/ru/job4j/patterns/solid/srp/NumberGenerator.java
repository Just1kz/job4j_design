package ru.job4j.patterns.solid.srp;

public interface NumberGenerator<T> {
    T generate();
}
