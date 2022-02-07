package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list.stream()
                .filter(s -> {
                    String[] str = s.split(" ");
                    return str[str.length - 2].equals("404");
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        log.forEach(System.out::println);
    }
}