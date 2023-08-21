package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

public class ReportForHRDepTest  {
    @Test
    public void whenThreeEmployees() {
        Store store = new MemStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportForHRDep report = new ReportForHRDep(store, parser);
        Calendar calendar = Calendar.getInstance();
        store.add(new Employee("Ivanov", calendar, calendar, 34000));
        store.add(new Employee("Petrov", calendar, calendar, 40000));
        store.add(new Employee("Sidorov", calendar, calendar, 42500));
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append("Sidorov 42500.0").append(System.lineSeparator())
                .append("Petrov 40000.0").append(System.lineSeparator())
                .append("Ivanov 34000.0");
        assertThat(report.generate(em -> true)).isEqualTo(expected.toString());
    }
}