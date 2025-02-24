package ru.job4j.ood.lsp.productstore;


import java.util.List;

public interface Store {
    public boolean acceptFood(Food food);

    public void setLimitPercent();

    public List<Food> getAllFood();

    public void cleanStore();
}
