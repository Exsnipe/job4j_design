package ru.job4j.examio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Validator {
    private static final String[] ALL_ARGS = {"-d", "-n", "-t", "-o"};

    public static Map<String, String> validate(String inputArg, String[] necessaryArgs) {
        Map<String, String> result;
        if (inputArg == null) {
            throw new IllegalArgumentException("Введите параметры поиска");
        }
        String[] keys = inputArg.split(" ");
        result = Arrays.stream(keys)
                .filter(s -> s.length() > 0)
                .collect(Collectors.toMap(
                    e -> {
                        String[] spl = e.split("=", 2);
                        if (spl.length < 2 || spl[0].isEmpty() || spl[1].isEmpty()) {
                            throw new IllegalArgumentException();
                        }
                        return spl[0];
                    },
                    e -> e.split("=")[1]
                ));
        for (String arg : necessaryArgs) {
            if (result.get(arg) == null) {
                throw new IllegalArgumentException(String.format("There are no %s argument", arg));
            }
        }
        Path dir = Paths.get(result.get("-d"));
        return result;
    }

    public static Map<String, String> validate(String inputArg) {
        return validate(inputArg, ALL_ARGS);
    }
}
