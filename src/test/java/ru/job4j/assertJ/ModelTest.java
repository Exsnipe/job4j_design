/*package ru.job4j.assertJ;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ModelTest {
    @Test
    public void checkBoolean() {
        Model model = new Model(2, 3.6d, "Fantom", false);
        boolean result = model.isCondition();
        assertThat(result).isFalse();
    }

    @Test
    void whenStringChain() {
        Model model = new Model(1, 5.255d, "I am learning Java", true);
        String result = model.getLine();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("Javascript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    @Test
    void checkInt() {
        Model model = new Model(2, 5.2d, "name", true);
        int result = model.getTop();
        assertThat(result).isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(3)
                .isEqualTo(2);
    }

    @Test
    void checkDoubleChain()

}*/
