package ru.job4j.ood.solid.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineJsonTest {

    @Test
    public void generateEngineJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Anton", now, now, 1000);
        store.add(worker);
        ReportEngineJson engine = new ReportEngineJson(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append("{")
                .append(System.lineSeparator())
                .append(34).append("name").append(34)
                .append(" : ")
                .append(34).append(worker.getName()).append(34).append(",")
                .append(System.lineSeparator())
                .append(34).append("hired").append(34)
                .append(" : ")
                .append(worker.getHired()).append(",")
                .append(System.lineSeparator())
                .append(34).append("fired").append(34)
                .append(" : ")
                .append(worker.getFired()).append(",")
                .append(System.lineSeparator())
                .append(34).append("salary").append(34)
                .append(" : ")
                .append(worker.getSalary())
                .append(System.lineSeparator())
                .append("}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}