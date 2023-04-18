package ru.job4j.examio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.examio.Validator.validate;

public class ValidatorTest {

    @Test
    public void whenWithoutArray() {
        Map<String, String> result;
        Map<String, String> expected = Map.of(
                "-d", "c:/projects/job4j_design",
                "-n", "mtm.png",
                "-t", "mask",
                "-o", "log.txt"
        );
        String args = "-d=c:/projects/job4j_design -n=mtm.png -t=mask -o=log.txt";
        result = validate(args);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotExists() {
        String args = "-d=c:/projects/job4j -n=mtm.png -t=mask -o=log.txt";
        assertThatThrownBy(() -> validate(args)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Directory does not exists");
    }

    @Test
    public void whenNotAllArguments() {
        String args = "-d=c:/projects/job4j -t=mask -o=log.txt";
        assertThatThrownBy(() -> validate(args)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("There are no -n argument");
    }

    @Test
    public void whenWithArray() {
        Map<String, String> result;
        Map<String, String> expected = Map.of(
                "-d", "c:/projects/job4j_design",
                "-n", "mtm.png",
                "-t", "mask",
                "-o", "log.txt"
        );
        String args = "-d=c:/projects/job4j_design -n=mtm.png -t=mask -o=log.txt";
        result = validate(args, new String[] {"-d", "-n", "-t", "-o"});
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWithArrayNoOneArgument() {
        String args = "-d=c:/projects/job4j_design -t=mask -o=log.txt";
        assertThatThrownBy(() -> validate(args, new String[] {"-d", "-n", "-t", "-o"}))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("There are no -n argument");
    }
}