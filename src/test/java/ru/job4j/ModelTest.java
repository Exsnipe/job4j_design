package ru.job4j;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ModelTest {

    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean result = model.isConditio();
        assertThat(result).isTrue();
    }

    @Test
    void checkStringChain() {
        Model model = new Model(1, 5.255d, "I am learning Java", true);
        String result = model.getLine();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    @Test
    void checkInt() {
        Model model = new Model(2, 5.255d, "I am learning Java", true);
        int result = model.getTop();
        assertThat(result).isNotZero()
                .isEven()
                .isPositive()
                .isGreaterThan(1)
                .isLessThan(3)
                .isEqualTo(2);
    }

    @Test
    void checkDoubleChain() {
        Model model = new Model(1, 5.255d, "I am learning Java", true);
        double result = model.getNum();
        assertThat(result).isEqualTo(5.254d, withPrecision(0.003d))
                .isCloseTo(5.256d, withPrecision(0.01d))
                .isCloseTo(5.254d, Percentage.withPercentage(1.0d))
                .isGreaterThan(5.254d)
                .isLessThan(5.256d);
    }
}