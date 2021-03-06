package ru.job4j.ood.solid.srp.reports;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportAccountingDepartmentTest {

    @Test
    public void generateAccountingDepartmentNew() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Anton", now, now, 1000);
        store.add(worker);
        ReportAccountingDepartment engine = new ReportAccountingDepartment(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append("RUB.COP; ");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}