package ru.job4j.ood.lsp.carparking.model;

public class Car {
    private int takesParkingSpaces;

    public Car(int takesParkingSpaces) {
        this.takesParkingSpaces = takesParkingSpaces;
    }

    public int getTakesParkingSpaces() {
        return takesParkingSpaces;
    }
}
