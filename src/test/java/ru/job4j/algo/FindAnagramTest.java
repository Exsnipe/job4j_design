package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class FindAnagramTest {

    @Test
    public void whenFindAnagram() {
        String input = "asdfgydaskksad";
        String subStr = "das";
        var result = Arrays.asList(0, 6, 11);
        FindAnagram findAnagram = new FindAnagram();
        assertThat(findAnagram.findAnagrams(input, subStr)).isEqualTo(result);
    }

}