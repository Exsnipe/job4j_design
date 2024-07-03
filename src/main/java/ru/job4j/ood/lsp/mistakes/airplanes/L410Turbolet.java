package ru.job4j.ood.lsp.mistakes.airplanes;

public class L410Turbolet extends Airplane {

    public L410Turbolet(int emergencyFuelLevel) {
        super(emergencyFuelLevel);
    }

    @Override
    public boolean safetyFuelLeve(int distanceToAirfield) {
        return emergencyFuelLevel > 600 && emergencyFuelLevel > distanceToAirfield / 1000;
    }
}
