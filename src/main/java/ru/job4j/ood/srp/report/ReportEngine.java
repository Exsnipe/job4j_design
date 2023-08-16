package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class ReportEngine implements Report {

    //private final Store store;

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
