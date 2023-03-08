package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> customerQueue;
    private final int amount;

    public AppleStore(Queue<Customer> queue, int amount) {
        this.customerQueue = queue;
        this.amount = amount;
    }

    public String getLastHappyCustomer() {
        for (int index = 0; index < amount - 1; index++) {
            customerQueue.poll();
        }
        return customerQueue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        this.getLastHappyCustomer();
        return customerQueue.poll().name();
    }
}
