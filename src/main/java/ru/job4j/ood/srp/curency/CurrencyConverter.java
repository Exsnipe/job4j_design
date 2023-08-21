package ru.job4j.ood.srp.curency;

public interface CurrencyConverter {
    double convert(Currency source, double sourceValue, Currency target);
}
