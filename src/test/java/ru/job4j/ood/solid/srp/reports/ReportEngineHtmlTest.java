package ru.job4j.ood.solid.srp.reports;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineHtmlTest {

    @Test
    public void generateEngineHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Anton", now, now, 1000);
        store.add(worker);
        ReportEngineHtml engine = new ReportEngineHtml(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append("<head>Name</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(worker.getName()).append("</body>")
                .append(System.lineSeparator())
                .append("<head>Hired</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(worker.getHired()).append("</body>")
                .append(System.lineSeparator())
                .append("<head>Fired</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(worker.getFired()).append("</body>")
                .append(System.lineSeparator())
                .append("<head>Salary</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(worker.getSalary()).append("</body>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}