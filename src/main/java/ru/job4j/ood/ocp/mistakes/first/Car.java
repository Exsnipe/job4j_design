package ru.job4j.ood.ocp.mistakes.first;

public class Car {
    private Tire[] tires = new Tire[4];

    public boolean checkTiresPressure() {
        for (int i = 0; i < 4; i++) {
            if (!tires[i].checkPressure()) {
                return false;
            }
        }
        return true;
    }

    class Tire {
        private boolean normalPressure;

        public boolean checkPressure() {
            return normalPressure;
        }
    }
}
