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
                    .append(34).append("name").append(34)
                    .append(" : ")
                    .append(34).append(employee.getName()).append(34).append(",")
                    .append(System.lineSeparator())
                    .append(34).append("hired").append(34)
                    .append(" : ")
                    .append(employee.getHired()).append(",")
                    .append(System.lineSeparator())
                    .append(34).append("fired").append(34)
                    .append(" : ")
                    .append(employee.getFired()).append(",")
                    .append(System.lineSeparator())
                    .append(34).append("salary").append(34)
                    .append(" : ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator())
                    .append("}");
        }
        return text.toString();
    }
}
