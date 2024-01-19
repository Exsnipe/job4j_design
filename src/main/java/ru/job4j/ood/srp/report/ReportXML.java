package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.CalendarAdapterXml;
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
    private final Marshaller marshaller;

    public ReportXML(Store store, Marshaller marshaller) {
        this.store = store;
        this.marshaller = marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            result = writer.getBuffer().toString();
        } catch (IOException | JAXBException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Store store1 = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();

        store1.add(new Employee("Ivanov", calendar, calendar1, 45000));

        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller1 = context.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        ReportXML report = new ReportXML(store1, marshaller1);
        System.out.println(report.generate((employee -> true)));
        System.out.println("--------------------------------------------------------");
        System.out.println(store1.findBy((employee -> employee.getName().equals("Ivanov"))).get(0).getFired());
        /*String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller1.marshal(new Employees(store1.findBy((em) -> true)), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(xml);*/
    }
}
