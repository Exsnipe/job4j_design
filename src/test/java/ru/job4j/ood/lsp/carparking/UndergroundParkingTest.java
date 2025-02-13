package ru.job4j.ood.lsp.carparking;

import org.junit.jupiter.api.*;
import ru.job4j.ood.lsp.carparking.model.Car;
import ru.job4j.ood.lsp.carparking.model.PassengerCar;
import ru.job4j.ood.lsp.carparking.model.Truck;

import static org.assertj.core.api.Assertions.*;

public class UndergroundParkingTest {
    @Test
    public void whenPassengerCarParked() {
        CarParkingService service =
                new UndergroundParking(10, 5);
        Car car = new PassengerCar();
        assertThat(service.park(car)).isTrue();
    }

    @Test
    public void whenThereAreNoPlaceForTwoCars() {
        CarParkingService service =
                new UndergroundParking(5, 1);
        Car car1 = new PassengerCar();
        Car car2 = new PassengerCar();
        assertThat(service.park(car1)).isTrue();
        assertThat(service.park(car2)).isFalse();
    }

    @Test
    public void whenTruckParked() {
        CarParkingService service =
                new UndergroundParking(5, 5);
        Car truck = new Truck(4);
        assertThat(service.park(truck)).isTrue();
    }

    @Test
    public void whenNoSpaceForTruck() {
        CarParkingService service =
                new UndergroundParking(5, 5);
        Car truck = new Truck(6);
        assertThat(service.park(truck)).isFalse();
    }

    @Test
    public void whenTruckParkedAndFourSpacesRemained() {
        CarParkingService service =
                new UndergroundParking(10, 5);
        Car truck = new Truck(6);
        assertThat(service.park(truck)).isTrue();
        assertThat(service.trucksSpacesRemained()).isEqualTo(4);
        assertThat(service.passengerCarsSpacesRemained()).isEqualTo(5);
    }

    @Test
    public void whenSecondTruckParkedToPassengerCarsSpace() {
        CarParkingService service =
                new UndergroundParking(10, 10);
        Car truck1 = new Truck(6);
        Car truck2 = new Truck(5);
        assertThat(service.park(truck1)).isTrue();
        assertThat(service.park(truck2)).isTrue();
        assertThat(service.trucksSpacesRemained()).isEqualTo(4);
        assertThat(service.passengerCarsSpacesRemained()).isEqualTo(5);
    }
}