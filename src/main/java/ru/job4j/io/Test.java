package ru.job4j.io;

public class Test {
    public static void main(String[] args) {
        String expected = String.join(
                System.lineSeparator(),
                "name;age",
                "Tom;20",
                "Jack;25",
                "William;30"
        ).concat(System.lineSeparator());
        System.out.println(expected);
    }
}
