package ru.job4j.serialization.json;

import java.util.Arrays;

public class Airplane {
    private final String type;
    private final int weight;
    private final boolean isReactive;
    private final Crew crew;
    private final int[] cycle;

    public Airplane(String type, int weight, boolean isReactive, Crew crew, int[] cycle) {
        this.type = type;
        this.weight = weight;
        this.isReactive = isReactive;
        this.crew = crew;
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return "Airplane{"
                + "type=" + type
                + "weight=" + weight
                + ", isReactive=" + isReactive
                + ", crew=" + crew
                + ", cycle=" + Arrays.toString(cycle)
                + '}';
    }
}
