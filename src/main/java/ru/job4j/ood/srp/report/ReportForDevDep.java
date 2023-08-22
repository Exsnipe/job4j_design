package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportForDevDep implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;

    public ReportForDevDep(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        result.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            result.append(
                    String.join(",", employee.getName(), parser.parse(employee.getHired()),
                            parser.parse(employee.getFired()), String.valueOf(employee.getSalary()))
            ).append(System.lineSeparator());
        }
        return result.toString();
    }
}
