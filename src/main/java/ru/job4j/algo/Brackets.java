package ru.job4j.algo;

import java.util.Deque;
import java.util.LinkedList;

public class Brackets {
    public boolean isValid(String s) {
        Deque<Character> result = new LinkedList<>();
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        result.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            if (result.peek() != null && ((123 == result.peek() && s.charAt(i) == 125)
                    || (result.peek() == 40 && s.charAt(i) == 41)
                    || result.peek() == 91 && s.charAt(i) == 93)) {
                result.pop();
                continue;
            }
            result.push(s.charAt(i));
        }
        return result.isEmpty();
    }
}
