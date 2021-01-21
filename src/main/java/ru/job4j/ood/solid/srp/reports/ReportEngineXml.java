package ru.job4j.ood.solid.srp.reports;

import java.util.function.Predicate;

public class ReportEngineXml implements Report {
    private final Store store;

    public ReportEngineXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; ");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("<employee>")
                    .append("<name>")
                    .append(employee.getName()).append("</name>")
                    .append("<hired>")
                    .append(employee.getHired()).append("</hired>")
                    .append("<fired>")
                    .append(employee.getFired()).append("</fired>")
                    .append("<salary>")
                    .append(employee.getSalary()).append("</salary>")
                    .append("</employee>");
        }
        return text.toString();
    }
}
