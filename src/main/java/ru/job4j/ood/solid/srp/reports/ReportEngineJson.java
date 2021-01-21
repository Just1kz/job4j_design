package ru.job4j.ood.solid.srp.reports;

import java.util.function.Predicate;

public class ReportEngineJson  implements Report {
    private final Store store;

    public ReportEngineJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("{")
                    .append(System.lineSeparator())
                    .append("\"name\"")
                    .append(" : ")
                    .append("\"").append(employee.getName()).append("\"").append(",")
                    .append(System.lineSeparator())
                    .append("\"hired\"")
                    .append(" : ")
                    .append(employee.getHired()).append(",")
                    .append(System.lineSeparator())
                    .append("\"fired\"")
                    .append(" : ")
                    .append(employee.getFired()).append(",")
                    .append(System.lineSeparator())
                    .append("\"salary\"")
                    .append(" : ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator())
                    .append("}");
        }
        return text.toString();
    }
}
