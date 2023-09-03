package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

public class ReportJSONTest {
    @Test
    public void whenOneEmployee() {
        Store store = new MemStore();
        Report report = new ReportJSON(store);
        Calendar calendar = GregorianCalendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(new Employee("Ivanov", calendar, calendar, 50000));
        String result = "[{\"name\":\"Ivanov\",\"hired\":\"" + parser.parse(calendar)
                + "\",\"fired\":\"" + parser.parse(calendar) + "\",\"salary\":50000.0}]";
        assertThat(report.generate((em) -> true)).isEqualTo(result);
    }
}