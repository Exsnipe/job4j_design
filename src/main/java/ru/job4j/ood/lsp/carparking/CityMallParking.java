package ru.job4j.ood.lsp.carparking;

import ru.job4j.ood.lsp.carparking.model.Car;

public class CityMallParking implements CarParkingService {
    private int passengerCarsParkingSpaces;

    public CityMallParking(int passengerCarsParkingSpaces) {
        setAmountOfParkingSpaces(0, passengerCarsParkingSpaces);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public void setAmountOfParkingSpaces(int trucks, int passengerCars) {
        this.passengerCarsParkingSpaces = passengerCars;
    }

    @Override
    public int passengerCarsSpacesRemained() {
        return 0;
    }

    @Override
    public int trucksSpacesRemained() {
        return 0;
    }
}
