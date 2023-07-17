package ru.job4j.cache.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class TestFile {
    public static void main(String[] args) {
        Path dir = Path.of("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\cache\\files");
        Path file = Path.of("test.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(String.valueOf(dir), String.valueOf(file))))) {
            reader.lines()
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
