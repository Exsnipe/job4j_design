package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.CalendarAdapterJson;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson gson;

    public ReportJSON(Store store) {
        this.store = store;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Calendar.class, new CalendarAdapterJson());
        gsonBuilder.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson());
        gson = gsonBuilder.create();
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
