package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFile {
    public static void main(String[] args) throws IOException {
        AbstractCache<String, String> cache = new DirFileCacheFactory().getCacheInstance(
                "C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\cache\\files"
        );
        System.out.println(cache.get("test.txt"));
        System.out.println(cache.get("test.txt"));
    }
}
