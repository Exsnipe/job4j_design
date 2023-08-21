package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.curency.Currency;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

public class ReportEngineForAccDepTest {
    @Test
    public void whenDefaultCurrency() {
        Store store = new MemStore();
        Calendar calendar = new GregorianCalendar();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportForAccDep engine = new ReportForAccDep(store, parser);
        Employee employee = new Employee("Ivanov I.I.", calendar, calendar, 100000);
        store.add(employee);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append(" ")
                .append(parser.parse(employee.getHired())).append(" ")
                .append(parser.parse(employee.getFired())).append(" ")
                .append(employee.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void whenEuroCurrencyOneEmployee() {
        Store store = new MemStore();
        Calendar calendar = new GregorianCalendar();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportForAccDep engine = new ReportForAccDep(store, parser);
        engine.setCurrency(Currency.EUR);
        Employee employee = new Employee("Ivanov I.I.", calendar, calendar, 100000);
        store.add(employee);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append(" ")
                .append(parser.parse(employee.getHired())).append(" ")
                .append(parser.parse(employee.getFired())).append(" ")
                .append(String.format("%.5f", 1660D))
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expected.toString());
    }

    @Test
    public void whenDefaultCurrencyWithFilter() {
        Store store = new MemStore();
        Calendar calendar = new GregorianCalendar();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportForAccDep engine = new ReportForAccDep(store, parser);
        Employee employee1 = new Employee("Ivanov I.I.", calendar, calendar, 100000);
        Employee employee2 = new Employee("Petrov P.P.", calendar, calendar, 200000);
        Employee employee3 = new Employee("Stepanov S.S.", calendar, calendar, 300000);
        store.add(employee1);
        store.add(employee2);
        store.add(employee3);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee2.getName()).append(" ")
                .append(parser.parse(employee2.getHired())).append(" ")
                .append(parser.parse(employee2.getFired())).append(" ")
                .append(employee2.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName().startsWith("P"))).isEqualTo(expected.toString());
    }
}