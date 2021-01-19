package ru.job4j.ood.solid.srp.reports;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportHRDepartmentTest {

    @Test
    public void generateHRNew() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("AntonSecond", now, now, 800);
        Employee worker2 = new Employee("AntonFirst", now, now, 1000);
        store.add(worker);
        store.add(worker2);
        ReportHRDepartment engine = new ReportHRDepartment(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary; ")
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append("; ")
                .append(worker.getName()).append("; ")
                .append(worker.getSalary()).append("; ");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}