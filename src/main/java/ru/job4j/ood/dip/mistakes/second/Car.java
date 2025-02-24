package ru.job4j.ood.dip.mistakes.second;

public class Car {
    private Engine engine;
    private ManualGearBox gearBox;

    public Car(Engine engine, ManualGearBox gearBox) {
        this.engine = engine;
        this.gearBox = gearBox;
    }
}
