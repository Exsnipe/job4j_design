package ru.job4j.ood.lsp.carparking;

import ru.job4j.ood.lsp.carparking.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UndergroundParking implements CarParkingService {
    private int truckParkingSpaces;
    private int passengerCarsParkingSpaces;
    private int occupiedTruckPlaces;
    private int occupiedPassCarPlaces;
    private List<Car> passengerCars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

    public UndergroundParking(int truckParkingSpaces, int passengerCarsParkingSpaces) {
        setAmountOfParkingSpaces(truckParkingSpaces, passengerCarsParkingSpaces);
    }

    @Override
    public boolean park(Car car) {
        if (car.getTakesParkingSpaces() == 1) {
            return parkPassengerCar(car);
        }
        return parkTruck(car);
    }

    @Override
    public void setAmountOfParkingSpaces(int trucks, int passengerCars) {
        truckParkingSpaces = trucks;
        passengerCarsParkingSpaces = passengerCars;
    }

    @Override
    public int passengerCarsSpacesRemained() {
        return passengerCarsParkingSpaces - occupiedPassCarPlaces;
    }

    @Override
    public int trucksSpacesRemained() {
        return truckParkingSpaces - occupiedTruckPlaces;
    }

    private boolean parkPassengerCar(Car car) {
        if (passengerCarsSpacesRemained() < car.getTakesParkingSpaces()) {
            return false;
        }
        passengerCars.add(car);
        occupiedPassCarPlaces += car.getTakesParkingSpaces();
        return true;
    }

    private boolean parkTruck(Car car) {
        if (trucksSpacesRemained() >= car.getTakesParkingSpaces()) {
            trucks.add(car);
            occupiedTruckPlaces += car.getTakesParkingSpaces();
            return true;
        }
        return parkPassengerCar(car);
    }
}
