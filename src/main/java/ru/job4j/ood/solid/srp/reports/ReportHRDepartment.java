package ru.job4j.ood.solid.srp.reports;

import java.util.List;
import java.util.function.Predicate;

public class ReportHRDepartment implements Report {
    private final Store store;

    public ReportHRDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary; ");
        List<Employee> rsl =  store.findBy(filter);
        rsl.sort(new EmployeeDescBySalary());
        for (Employee employee :  rsl) {
            text
                    .append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append("; ");
        }
        return text.toString();
    }
}
