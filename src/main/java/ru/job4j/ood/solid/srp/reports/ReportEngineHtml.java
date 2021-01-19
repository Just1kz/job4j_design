package ru.job4j.ood.solid.srp.reports;

import java.util.function.Predicate;

public class ReportEngineHtml implements Report {
    private final Store store;

    public ReportEngineHtml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("<head>Name</head>")
                    .append(System.lineSeparator())
                    .append("<body>")
                    .append(employee.getName()).append("</body>")
                    .append(System.lineSeparator())
                    .append("<head>Hired</head>")
                    .append(System.lineSeparator())
                    .append("<body>")
                    .append(employee.getHired()).append("</body>")
                    .append(System.lineSeparator())
                    .append("<head>Fired</head>")
                    .append(System.lineSeparator())
                    .append("<body>")
                    .append(employee.getFired()).append("</body>")
                    .append(System.lineSeparator())
                    .append("<head>Salary</head>")
                    .append(System.lineSeparator())
                    .append("<body>")
                    .append(employee.getSalary()).append("</body>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
