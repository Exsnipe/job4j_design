package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement
public class Airplane {
    @XmlAttribute
    private String type;
    @XmlAttribute
    private int weight;
    @XmlAttribute
    private boolean isReactive;
    private Crew crew;
    @XmlElementWrapper(name = "cycles")
    @XmlElement(name = "cycle")
    private int[] cycle;

    public Airplane() {
    }

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
