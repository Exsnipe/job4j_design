package ru.job4j.ood.lsp.mistakes.airplanes;

public class Airplane {
    protected int emergencyFuelLevel;

    public Airplane(int emergencyFuelLevel) {
        this.emergencyFuelLevel = emergencyFuelLevel;
    }

    public boolean safetyFuelLeve(int distanceToAirfield) {
        return emergencyFuelLevel > distanceToAirfield / 1000;
    }
}
