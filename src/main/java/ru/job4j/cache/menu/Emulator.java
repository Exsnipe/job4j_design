package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {
    private static final int INDICATE_CASHING_DIRECTORY = 1;
    private static final int LOAD_FILE_IN_CASH = 2;
    private static final int OBTAIN_CONTENT_OF_FILE = 3;

    private static Path directory;
    private static Path file;
    private DirFileCache dirFileCache;

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
            int answer = scanner.nextInt();
            if (answer == INDICATE_CASHING_DIRECTORY) {
                chooseDirectory(scanner);
            } else if (answer == LOAD_FILE_IN_CASH) {

            }
        }
    }

    private static DirFileCache chooseDirectory(Scanner scanner) {
        System.out.println("type directory path");
        String dir = scanner.nextLine();
        if (new File(dir).isDirectory()) {
            return new DirFileCache(dir);
        } else {
            System.out.println("Directory does not exists");
            return null;
        }
    }

    private static void loadFileInCash(Scanner scanner) {
        System.out.println("type name of file");
        String file = scanner.nextLine();
        Path filePath = Path.of(String.valueOf(directory), file);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
