package ru.job4j.collection.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleStoreTest {
    @Test
    void whenGetLast() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Alexei");
    }

    @Test
    void whenGetLastAgain() {
        Queue<Customer> queue = new LinkedList<>();
        queue.add(new Customer("Fedor", 3400));
        queue.add(new Customer("Roman", 5000));
        queue.add(new Customer("Zhanna", 2300));
        AppleStore appleStore = new AppleStore(queue, 2);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Roman");
    }

    @Test
    void whenGetFirst() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isEqualTo("Iryna");
    }

}