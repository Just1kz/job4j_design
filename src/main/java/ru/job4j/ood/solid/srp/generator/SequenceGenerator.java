package ru.job4j.ood.solid.srp.generator;

import java.util.List;

public interface SequenceGenerator<T> {
    List<T> generate(int size);
}
