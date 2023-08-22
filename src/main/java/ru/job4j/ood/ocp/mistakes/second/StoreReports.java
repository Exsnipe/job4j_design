package ru.job4j.ood.ocp.mistakes.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreReports {
    private List<String> reports = new ArrayList<>();
    private int amount;

    public StoreReports(int amount) {
        this.amount = amount;
    }

    public void fullReports() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < amount; i++) {
            reports.add(scanner.nextLine());
        }
    }
}
