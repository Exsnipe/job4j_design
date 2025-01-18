package ru.job4j.testinterface;

public class SportCar implements Vehicle, Fuel {

    @Override
    public void ride() {
        System.out.println("Ride");
    }

    @Override
    public int currentSpeed() {
        return 200;
    }

    @Override
    public void refill() {
        System.out.println("Car is full");
    }
}
