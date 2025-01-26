package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class GeneratorClassTest {
    @Test
    public void whenSuccessfullyChanged() {
        String template = "Nice to meet you, ${name}. Welcome to the ${city}";
        Map<String, String> args = Map.of("name", "Dima", "city", "Minsk");
        Generator generator = new GeneratorClass();
        String result = generator.produce(template, args);
        assertThat(result).isEqualTo("Nice to meet you, Dima. Welcome to the Minsk");
    }

    @Test
    public void whenThereAreNoArgInTemplateThenThrowEx() {
        String template = "Nice to meet you, ${name}. Welcome to the ${city}";
        Map<String, String> args = Map.of("name", "Dima",
                "surname", "Ivanov", "city", "Minsk");
        assertThatThrownBy(() -> new GeneratorClass().produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenRedundantArgInTemplateThenThrowEx() {
        String template = "Nice to meet you, ${name} ${surname}."
                + " Welcome to the ${city}";
        Map<String, String> args = Map.of("name", "Dima", "city", "Minsk");
        assertThatThrownBy(() -> new GeneratorClass().produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}