package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {
    private static final int INDICATE_CASHING_DIRECTORY = 1;
    private static final int LOAD_FILE_IN_CASH = 2;
    private static final int OBTAIN_CONTENT_OF_FILE = 3;

    private static Path directory;
    private static Path file;
    private static AbstractCache<String, String> dirFileCache;

    private static final String MENU = """
            Введите 1 для выбора кэшируемой директории.
            Введите 2 для загрузки содержимого файла в кэш.
            Введите 3 для получения содержимого файла из кэша.
            """;

    public static void main(String[] args) {
       start(new Scanner(System.in));
    }

    private static void start(Scanner scanner) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("press correct number");
                continue;
            }
            if (answer == INDICATE_CASHING_DIRECTORY) {
                dirFileCache = chooseDirectory(scanner);
            } else if (answer == LOAD_FILE_IN_CASH) {
                if (dirFileCache == null) {
                    System.out.println("Directory has not been chosen");
                    continue;
                }
                loadFileInCash(scanner);
            } else if (answer == OBTAIN_CONTENT_OF_FILE) {
                if (dirFileCache == null) {
                    System.out.println("Directory has not been chosen");
                    continue;
                }
                System.out.println("Press file name");
                String fileName = scanner.nextLine();
                System.out.println(dirFileCache.get(fileName));
            } else {
                run = false;
                System.out.println("Program has been canceled");
            }
        }
    }

    private static DirFileCache chooseDirectory(Scanner scanner) {
        System.out.println("Press directory path");
        String dir = scanner.nextLine();
        if (new File(dir).isDirectory()) {
            return new DirFileCache(dir);
        } else {
            System.out.println("Directory does not exists");
            return null;
        }
    }

    private static void loadFileInCash(Scanner scanner) {
        System.out.println("Press file name");
        String fileName = scanner.nextLine();
        dirFileCache.put(fileName, dirFileCache.get(fileName));
    }
}
