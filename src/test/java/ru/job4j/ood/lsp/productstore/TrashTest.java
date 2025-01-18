package ru.job4j.ood.lsp.productstore;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class TrashTest {

    @Test
    public void whenFoodIsNotAcceptedToTrash() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(23);
        LocalDate creationDate = today.minusDays(7);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        Store trash = new Trash();
        assertThat(trash.acceptFood(milk)).isFalse();
    }

    @Test
    public void whenFoodAcceptedToTrash() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.minusDays(1);
        LocalDate creationDate  = today.minusDays(31);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        Store trash = new Trash();
        assertThat(trash.acceptFood(milk)).isTrue();
    }
}