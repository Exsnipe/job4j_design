package ru.job4j.cache.menu;

import java.util.Scanner;

public class Emulator {
    private static final int INDICATE_CASHING_DIRECTORY = 1;
    private static final int LOAD_FILE_IN_CASH = 2;
    private static final int OBTAIN_CONTENT_OF_FILE = 3;

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

        }
        System.out.println(MENU);

    }
}
