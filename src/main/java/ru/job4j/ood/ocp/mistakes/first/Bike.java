package ru.job4j.ood.ocp.mistakes.first;

public class Bike extends Car {
    private Tire[] tires = new Tire[2];

    @Override
    public boolean checkTiresPressure() {
        for (int i = 0; i < 2; i++) {
            if (!tires[i].checkPressure()) {
                return false;
            }
        }
        return true;
    }
}
