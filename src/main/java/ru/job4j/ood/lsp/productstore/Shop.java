package ru.job4j.ood.lsp.productstore;

import java.time.LocalDate;
import java.util.List;

public class Shop extends AbstractStore {

    @Override
    public void setLimitPercent() {
        setLowLimitPercent(0.25);
        setHighLimitPercent(1.0);
    }

    @Override
    public boolean acceptFood(Food food) {
        if (!super.acceptFood(food)) {
            return false;
        }
        if (food.getPercentRemaining() > 0.75) {
            food.setPrice((int) (food.getPrice() * 0.8));
        }
        return true;
    }
}
