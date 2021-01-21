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
                .append("\"name\"")
                .append(" : ")
                .append("\"").append(worker.getName()).append("\"").append(",")
                .append(System.lineSeparator())
                .append("\"hired\"")
                .append(" : ")
                .append(worker.getHired()).append(",")
                .append(System.lineSeparator())
                .append("\"fired\"")
                .append(" : ")
                .append(worker.getFired()).append(",")
                .append(System.lineSeparator())
                .append("\"salary\"")
                .append(" : ")
                .append(worker.getSalary())
                .append(System.lineSeparator())
                .append("}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}