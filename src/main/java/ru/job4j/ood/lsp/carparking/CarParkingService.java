package ru.job4j.ood.lsp.carparking;

import ru.job4j.ood.lsp.carparking.model.Car;

public interface CarParkingService {
    public boolean park(Car car);

    public void setAmountOfParkingSpaces(
            int trucks, int passengerCars
    );

    public int passengerCarsSpacesRemained();

    public int trucksSpacesRemained();
}
