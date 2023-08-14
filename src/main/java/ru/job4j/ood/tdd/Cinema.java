package ru.job4j.ood.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    public List<Session> find(Predicate<Session> filter);

    public Ticket buy(Account account, int row, int column, Calendar date);

    public void add(Session session);
}
