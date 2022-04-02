package ru.job4j.serialization.json;

public class Crew {
    private final int amount;

    public Crew(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Crew{"
                + "amount=" + amount
                + '}';
    }
}

