package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        StringBuilder result = new StringBuilder();
        char symbol = input.charAt(0);
        int counter = 0;
        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == symbol) {
                counter++;
            } else {
                result.append(symbol);
                if (counter > 0) {
                    result.append(++counter);
                }
                symbol = input.charAt(index);
                counter = 0;
            }
        }
        if (counter > 0) {
            result.append(symbol).append(++counter);
        } else {
            result.append(symbol);
        }
        return result.toString();
    }
}
