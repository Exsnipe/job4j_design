package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;


public class ReportForDevDepTest {
    @Test
    public void whenOneEmployee() {
        Store store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee employee = new Employee("Ivan", calendar, calendar, 90000);
        store.add(employee);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(String.join(",", "Ivan", parser.parse(employee.getHired()),
                        parser.parse(employee.getFired()), String.valueOf(employee.getSalary())))
                .append(System.lineSeparator());
        Report report = new ReportForDevDep(store, parser);
        assertThat(report.generate(em -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void whenTwoEmployees() {
        Store store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee employee1 = new Employee("Ivan", calendar, calendar, 90000);
        Employee employee2 = new Employee("Petrov", calendar, calendar, 92000);
        store.add(employee1);
        store.add(employee2);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(String.join(",", employee1.getName(), parser.parse(employee1.getHired()),
                        parser.parse(employee1.getFired()), String.valueOf(employee1.getSalary())))
                .append(System.lineSeparator())
                .append(String.join(",", employee2.getName(), parser.parse(employee1.getHired()),
                        parser.parse(employee1.getFired()), String.valueOf(employee2.getSalary())))
                .append(System.lineSeparator());
        Report report = new ReportForDevDep(store, parser);
        assertThat(report.generate(em -> true)).isEqualTo(expected.toString());
    }

}