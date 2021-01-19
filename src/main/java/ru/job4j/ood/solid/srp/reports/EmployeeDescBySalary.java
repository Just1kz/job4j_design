package ru.job4j.ood.solid.srp.reports;

import java.util.Comparator;

public class EmployeeDescBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.compareTo(o1);
    }
}
