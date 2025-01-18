package ru.job4j.ood.lsp.productstore;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ControlQualityTest {

    @Test
    public void whenFoodSortedToWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        Store wareHouse = new WareHouse();
        Store shop = new Shop();
        Store trash = new Trash();
        controlQuality.addStore(wareHouse);
        controlQuality.addStore(shop);
        controlQuality.addStore(trash);
        LocalDate today = LocalDate.now();
        LocalDate expireDate = today.plusDays(23);
        LocalDate creationDate = today.minusDays(7);
        Food milk = new Food(
                "milk",
                expireDate,
                creationDate,
                95
        );
        controlQuality.sortFood(milk);
        assertThat(wareHouse.getAllFood()).hasSize(1);
        assertThat(wareHouse.getAllFood().get(0).getName()).isEqualTo("milk");
    }

    @Test
    public void whenFoodSortedToShop() {
        List<Store> stores = List.of(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate today = LocalDate.now();
        Food milk = new Food(
                "milk",
                today.plusDays(22),
                today.minusDays(8),
                95
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sortFood(milk);
        assertThat(controlQuality.getStores().get(1)
                .getAllFood()).hasSize(1);
        assertThat(controlQuality.getStores().get(1)
                .getAllFood().get(0).getName()).isEqualTo("milk");
    }

    @Test
    public void whenFoodAcceptedToShopAndDiscount() {
        List<Store> stores = List.of(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate today = LocalDate.now();
        Food milk = new Food(
                "milk",
                today.plusDays(5),
                today.minusDays(25),
                95
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sortFood(milk);
        assertThat(controlQuality.getStores().get(1)
                .getAllFood()).hasSize(1);
        assertThat(controlQuality.getStores().get(1)
                .getAllFood().get(0).getName()).isEqualTo("milk");
        assertThat(controlQuality.getStores().get(1)
                .getAllFood().get(0).getPrice()).isEqualTo(76);
    }

    @Test
    public void whenFoodAcceptedToTrash() {
        List<Store> stores = List.of(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate today = LocalDate.now();
        Food milk = new Food(
                "milk",
                today.minusDays(1),
                today.minusDays(31),
                95
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.sortFood(milk);
        assertThat(controlQuality.getStores().get(2)
                .getAllFood()).hasSize(1);
        assertThat(controlQuality.getStores().get(2)
                .getAllFood().get(0).getName()).isEqualTo("milk");
    }

    @Test
    public void whenFoodDidNotSorted() {
        List<Store> stores = List.of(
                new WareHouse(),
                new Shop()
        );
        LocalDate today = LocalDate.now();
        Food milk = new Food(
                "milk",
                today.minusDays(1),
                today.minusDays(31),
                95
        );
        ControlQuality controlQuality = new ControlQuality(stores);
        assertThat(controlQuality.sortFood(milk)).isFalse();
    }
}