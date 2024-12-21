package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char symbol = input.charAt(0);
        int counter = 1;

        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == symbol) {
                counter++;
            } else {
                result.append(symbol);
                if (counter > 1) {
                    result.append(counter);
                }
                symbol = input.charAt(index);
                counter = 1;
            }
        }
        result.append(symbol);
        if (counter > 1) {
            result.append(counter);
        }

        return result.toString();
    }
}