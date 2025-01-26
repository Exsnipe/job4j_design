package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.curency.Currency;
import ru.job4j.ood.srp.curency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import java.util.Formatter;
import java.util.function.Predicate;

public class ReportForAccDep implements Report {
    private static final Currency DEFAULT_CURRENCY = Currency.RUB;

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private Currency targetCurrency = Currency.RUB;

    public ReportForAccDep(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public void setCurrency(Currency currency) {
        this.targetCurrency = currency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ");
            if (targetCurrency != DEFAULT_CURRENCY) {
                text.append(
                        String.format("%.5f", converter.convert(DEFAULT_CURRENCY,
                                employee.getSalary(), targetCurrency)));
            } else {
                text.append(employee.getSalary());
            }
            text.append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
    }
}
