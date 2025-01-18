package ru.job4j.ood.lsp.productstore;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    @Test
    public void whenFoodAccepted() {
        Store shop = new Shop();
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(22);
        LocalDate createDate = today.minusDays(8);
        Food milk = new Food(
                "milk",
                expireDate,
                createDate,
                95
        );
        assertThat(shop.acceptFood(milk)).isTrue();
    }

    @Test
    public void whenFoodDidNotAcceptBefore() {
        Store shop = new Shop();

        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(23);
        LocalDate creationDate = today.minusDays(7);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        assertThat(shop.acceptFood(milk)).isFalse();
    }

    @Test
    public void whenFoodDidNotAcceptedAfter() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today;
        LocalDate creationDate = today.minusDays(30);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        Store shop = new Shop();
        assertThat(shop.acceptFood(milk)).isFalse();
    }

    @Test
    public void whenFoodAcceptedAndDiscount() {
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(5);
        LocalDate creationDate = today.minusDays(25);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        Store shop = new Shop();
        assertThat(shop.acceptFood(milk)).isTrue();
        assertThat(shop.getAllFood().get(0).getPrice()).isEqualTo(76);
    }

}