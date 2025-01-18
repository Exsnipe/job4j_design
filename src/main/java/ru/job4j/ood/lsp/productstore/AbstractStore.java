package ru.job4j.ood.lsp.productstore;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private double lowLimitPercent;
    private double highLimitPercent;
    private final List<Food> foods = new ArrayList<>();

    public AbstractStore() {
        setLimitPercent();
    }

    public void setLowLimitPercent(double lowLimitPercent) {
        this.lowLimitPercent = lowLimitPercent;
    }

    public void setHighLimitPercent(double highLimitPercent) {
        this.highLimitPercent = highLimitPercent;
    }

    public double getLowLimitPercent() {
        return lowLimitPercent;
    }

    public double getHighLimitPercent() {
        return highLimitPercent;
    }

    @Override
    public boolean acceptFood(Food food) {
        double percentRemaining = food.getPercentRemaining();
        if (percentRemaining >= lowLimitPercent
        && percentRemaining < highLimitPercent) {
            foods.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getAllFood() {
        return foods;
    }
}
