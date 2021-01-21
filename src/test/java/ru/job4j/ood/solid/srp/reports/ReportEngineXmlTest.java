package ru.job4j.ood.solid.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineXmlTest {

    @Test
    public void generateEngineXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Anton", now, now, 1000);
        store.add(worker);
        ReportEngineXml engine = new ReportEngineXml(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append("<employee>")
                .append("<name>")
                .append(worker.getName()).append("</name>")
                .append("<hired>")
                .append(worker.getHired()).append("</hired>")
                .append("<fired>")
                .append(worker.getFired()).append("</fired>")
                .append("<salary>")
                .append(worker.getSalary()).append("</salary>")
                .append("</employee>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}