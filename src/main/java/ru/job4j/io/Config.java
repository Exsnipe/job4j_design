package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;

    private Map<String, String> value = new HashMap<String, String>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        value = lines.stream()
                .filter(s -> !s.startsWith("#") && s.length() > 0)
                .collect(Collectors.toMap(
                        e -> {
                            String[] spl = e.split("=", 2);
                            if (spl.length < 2 || (spl.length == 2
                                    && "".equals(spl[0]) || "".equals(spl[1]))) {
                                throw new IllegalArgumentException();
                            }
                            return e.split("=")[0];
                        },
                        e -> e.split("=")[1]
                ));
    }

    public String value(String key) {
        return value.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(out::add);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties");
        config.load();
        System.out.println(config.value.size());
        System.out.println(config.value("hibernate.connection.password"));
    }
}
