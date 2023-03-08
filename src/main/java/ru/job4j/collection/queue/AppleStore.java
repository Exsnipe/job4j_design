package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int amount;

    public AppleStore(Queue<Customer> queue, int amount) {
        this.queue = queue;
        this.amount = amount;
    }

    public String getLastHappyCustomer() {
        for (int index = 0; index < amount - 1; index++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        this.getLastHappyCustomer();
        return queue.poll().name();
    }
}
