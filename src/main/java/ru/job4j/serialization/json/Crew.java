package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Crew {
    private int amount;

    public Crew() {
    }

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

