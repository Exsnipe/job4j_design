package ru.job4j;

import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int password;
        do {
            System.out.println("Введите пароль");
            password = scanner.nextInt();
        } while (password != 555);
        System.out.println("Пароль введен успешно");
    }
}
