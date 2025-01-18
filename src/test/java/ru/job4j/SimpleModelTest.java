package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SimpleModelTest {

    @Test
    void checkGetName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(simpleModel::getName).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(() -> simpleModel.setName("name", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotNull();
    }

    @Test
    void checkWordMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(word, number);
    }
}