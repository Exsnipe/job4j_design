package ru.job4j.ood.lsp.productstore;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class FoodTest {

    @Test
    public void whenCreateFoodWithWrongDate() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(30);
        LocalDate creationDate = today.plusDays(15);
        Food milk = new Food(
                "Milk",
                expireDate,
                creationDate,
                95
        );
        assertThat(milk.getPercentRemaining()).isEqualTo(-1.0);
    }

    @Test
    public void whenExpireIsAfterToday() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.minusDays(5);
        LocalDate creationDate = today.minusDays(20);
        Food milk = new Food(
                "Milk",
                LocalDate.of(2025, 1, 15),
                LocalDate.of(2025, 1, 1),
                95
        );
        assertThat(milk.getPercentRemaining()).isGreaterThanOrEqualTo(1.0);
    }
}