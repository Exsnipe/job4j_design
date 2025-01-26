package ru.job4j.ood.srp.report;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class XmlReportEngineTest {
    @Test
    void whenGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller1 = context.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Report report = new ReportXML(store, marshaller1);
        String expect = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>John Doe</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Jane Smith</name>
                        <hired>08:06:2023 17:41</hired>
                        <fired>08:06:2023 17:41</fired>
                        <salary>6000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}