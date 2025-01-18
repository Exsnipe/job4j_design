package ru.job4j.ood.lsp.productstore;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class WareHouseTest {
    @Test
    public void whenFoodAccepted() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(23);
        LocalDate creationDate = today.minusDays(7);
        Food milk = new Food(
                "Milk",
                expireDate,
                creationDate,
                95
        );
        Store warehouse = new WareHouse();
        assertThat(warehouse.acceptFood(milk)).isTrue();
    }

    @Test
    public void whenFoodDidNotAccepted() {
        Store wareHouse = new WareHouse();
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(22);
        LocalDate creationDate = today.minusDays(8);
        Food milk = new Food("milk",
                expireDate,
                creationDate,
                95
        );
        assertThat(wareHouse.acceptFood(milk)).isFalse();
    }
}