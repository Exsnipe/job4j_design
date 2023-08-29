package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;
    private final Gson gson;

    public ReportJson(Store store, DateTimeParser<Calendar> parser, Gson gson) {
        this.store = store;
        this.parser = parser;
        this.gson = gson;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
       JSONArray jsonArray = new JSONArray();
       JSONObject jsonObject;
       for (Employee employee : store.findBy(filter)) {
           jsonObject = new JSONObject();
           jsonObject.put("name", employee.getName());
           jsonObject.put("hired", parser.parse(employee.getHired()));
           jsonObject.put("fired", parser.parse(employee.getFired()));
           jsonObject.put("salary", employee.getSalary());
           jsonArray.put(jsonObject);
       }
       return jsonArray.toString();
    }

    public static void main(String[] args) {
        Store store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        store.add(new Employee("Ivanov", calendar, calendar, 100000));
        store.add(new Employee("Petrov", calendar, calendar, 90000));
        Report report = new ReportJson(store, new ReportDateTimeParser(), new GsonBuilder().create());
        System.out.println(report.generate(employee -> true));
    }
}
