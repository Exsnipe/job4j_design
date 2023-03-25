package ru.job4j;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SimpleConverterTest {
    @Test
    void checkArray() {
        SimpleConverter simpleConverter = new SimpleConverter();
        String[] array = simpleConverter.toArray("one", "two", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("one")
                .contains("two", Index.atIndex(1))
                .containsAnyOf("zero", "four", "seven")
                .containsExactly("one", "two", "three", "four", "five");
    }

    @Test
    void checkList() {
        SimpleConverter simpleConverter = new SimpleConverter();
        List<String> result = simpleConverter.toList("one", "two", "three", "four", "five");
        assertThat(result).hasSize(5)
                .contains("three")
                .allMatch(s -> s.length() > 1)
                .containsExactlyInAnyOrder("two", "one", "four", "three", "five");
    }

    @Test
    void checkSet() {
        SimpleConverter simpleConverter = new SimpleConverter();
        Set<String> result = simpleConverter.toSet(
                "one", "two", "one", "three", "four", "five", "five");
        assertThat(result).hasSize(5)
                .anyMatch(s -> s.equals("five"))
                .doesNotContain("seven");
    }

    @Test
    void checkMap() {
        SimpleConverter simpleConverter = new SimpleConverter();
        Map<String, Integer> mapResult = simpleConverter.toMap(
                "one", "two", "one", "three", "four", "five", "five");
       assertThat(mapResult).isNotEmpty()
               .containsKey("two")
               .containsEntry("one", 0)
               .containsValue(5);
    }
}