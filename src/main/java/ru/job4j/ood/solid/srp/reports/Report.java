package ru.job4j.ood.solid.srp.reports;

import java.util.Comparator;
import java.util.function.Predicate;

public interface Report {
    public String generate(Predicate<Employee> filter);
}
