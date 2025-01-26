package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportForHRDep implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportForHRDep(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        store.findBy(filter).stream()
                .sorted(new CompBySalary())
                .forEach(em -> text.append(System.lineSeparator())
                        .append(em.getName()).append(" ").append(em.getSalary()));
        return text.toString();
    }

    private static class CompBySalary implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.getSalary(), o1.getSalary());
        }
    }

    public static void main(String[] args) {
        String data = String.join(
                " --- ",
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        System.out.println(data);
    }
}
