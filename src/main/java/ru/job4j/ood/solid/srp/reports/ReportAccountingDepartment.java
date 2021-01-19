package ru.job4j.ood.solid.srp.reports;

import java.util.function.Predicate;

public class ReportAccountingDepartment implements Report {
    private final Store store;

    public ReportAccountingDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append("RUB.COP; ");
        }
        return text.toString();
    }
}
