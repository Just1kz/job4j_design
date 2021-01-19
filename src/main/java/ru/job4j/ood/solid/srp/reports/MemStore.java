package ru.job4j.ood.solid.srp.reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    public List<Employee> sortSal(List<Employee> list, Comparator<Employee> comparator) {
        return employees.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
