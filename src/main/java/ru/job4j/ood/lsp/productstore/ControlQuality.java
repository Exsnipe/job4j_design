package ru.job4j.ood.lsp.productstore;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> stores = new ArrayList<>();

    public ControlQuality() {
    }

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void adAllStores(List<Store> stores) {
        this.stores = stores;
    }

    public boolean sortFood(Food food) {
        if (food.getPercentRemaining() == -1) {
            System.out.println("Food " + food.getName()
            + " Can't be accepted to any store, because"
            + " mistake has been detected in date information");
            return false;
        }
        for (Store store : stores) {
            if (store.acceptFood(food)) {
                System.out.println("The food \"" + food.getName()
                + "\" has been accepted to " + store.getClass().getSimpleName());
                return true;
            }
        }
        System.out.println("There is no suitable store for"
                + " the product: " + food.getName());
        return false;
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.getAllFood());
            store.cleanStore();
        }
        for (Food food : foods) {
            sortFood(food);
        }
    }
}
