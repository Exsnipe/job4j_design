package ru.job4j.ood.lsp.carparking;

import ru.job4j.ood.lsp.carparking.model.Car;

public class UndergroundParking implements CarParkingService {
    private int truckParkingSpaces;
    private int passengerCarsParkingSpaces;

    public UndergroundParking(int truckParkingSpaces, int passengerCarsParkingSpaces) {
        setAmountOfParkingSpaces(truckParkingSpaces, passengerCarsParkingSpaces);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public void setAmountOfParkingSpaces(int trucks, int passengerCars) {
        truckParkingSpaces = trucks;
        passengerCarsParkingSpaces = passengerCars;
    }
}
