package ru.job4j.ood.lsp.productstore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {

    private final String name;
    private final LocalDate expireDate;
    private final LocalDate createDate;
    private int price;
    private double percentRemaining = -1.0;

    public Food(String name, LocalDate expireDate,
                LocalDate createDate, int price) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        setPercentRemaining();
    }

    public void setPercentRemaining() {
        LocalDate today = LocalDate.now();
        if (createDate.isAfter(today)) {
            this.percentRemaining = -1.0;
            return;
        }
        if (today.isAfter(expireDate)) {
            this.percentRemaining = 1.0;
            return;
        }
        this.percentRemaining = (double) ChronoUnit.DAYS.between(createDate, today)
                / (double) ChronoUnit.DAYS.between(createDate, expireDate);
    }

    public double getPercentRemaining() {
        return percentRemaining;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
