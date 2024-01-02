package ru.job4j.smalltest;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class JUnitExampleTest {
    @Test
    public void when5And5Then25() {
        JUnitExample example = new JUnitExample();
        int result = example.multiply(5, 5);
        System.out.println("Proceed");
        assertThat(result).isEqualTo(25);
    }
}