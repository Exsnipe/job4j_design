package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String result = values.get(key);
        if (result == null) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] parts = arg.split("=", 2);
            if (parts[1].isEmpty()) {
                throw new IllegalArgumentException();
            }
            StringBuilder result = new StringBuilder(parts[0]);
            if (result.charAt(0) == '-') {
                result.deleteCharAt(0);
            }
            values.put(result.toString(), parts[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
