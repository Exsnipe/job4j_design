package ru.job4j.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAnagram {
    private Set<Character> toSet(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    public List<Integer> findAnagrams(String input, String subStr) {
        List<Integer> result = new ArrayList<>();
        Set<Character> anagrams = toSet(subStr);
        int windowSize = subStr.length();
        for (int i = 0; i <= input.length() - windowSize; i++) {
            String window = input.substring(i, i + windowSize);
            if (anagrams.equals(toSet(window))) {
                result.add(i);
            }
        }
        return result;
    }
}
