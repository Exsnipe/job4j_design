package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;
import ru.job4j.serialization.json.B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> parser;
    private final Marshaller marshaller;

    public ReportXML(Store store, DateTimeParser<Calendar> parser, Marshaller marshaller) {
        this.store = store;
        this.parser = parser;
        this.marshaller = marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store.findBy(filter), writer);
            result = writer.getBuffer().toString();
        } catch (IOException | JAXBException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Store store1 = new MemStore();
        Calendar calendar = Calendar.getInstance();
        /*store1.add(new Employee("Ivanov", calendar, calendar, 45000));
        store1.add(new Employee("Petrov", calendar, calendar, 50000));
        store1.add(new Employee("Sidorov", calendar, calendar, 65000));*/
        List<Employee> employeeList = List.of(
                new Employee("Ivanov", calendar, calendar, 45000),
                new Employee("Petrov", calendar, calendar, 50000),
                new Employee("Sidorov", calendar, calendar, 65000)
        );
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller1 = context.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller1.marshal(employeeList.get(1), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(xml);
    }
}
