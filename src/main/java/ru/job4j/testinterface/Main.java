package ru.job4j.testinterface;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar =  new SportCar();
        Vehicle vehicle = sportCar;
        Fuel fuel = sportCar;
        vehicle.ride();
        System.out.println(vehicle.currentSpeed());
        fuel.refill();
    }
}
