package ru.job4j.algo;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        String result = "";
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (!str.isEmpty()) {
            result = String.valueOf(str.charAt(0));
        }
        Set<Character> set = new HashSet<>();
        int maxRange = 0;
        int indexOfMaxRange = 0;
        int currentRange = 0;
        int currentIndex;
        for (int index = 0; index < str.length(); index++) {
            set.clear();
            currentRange = 0;
            currentIndex = index;
            while (currentIndex < str.length() && set.size() == currentRange) {
                set.add(str.charAt(currentIndex));
                currentRange++;
                currentIndex++;
            }
            currentRange = set.size();
            if (currentRange > maxRange) {
                maxRange = set.size();
                indexOfMaxRange = index;
            }
            result = str.substring(indexOfMaxRange, indexOfMaxRange + maxRange);
            if (maxRange > str.length() - index) {
                break;
            }
        }
        return result;
    }
}