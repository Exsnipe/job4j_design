package ru.job4j;

public class Loader {
    public static void main(String[] args) {
        Class loader = Loader.class;
        System.out.println(loader);
        System.out.println(loader.getClassLoader());
    }
}
