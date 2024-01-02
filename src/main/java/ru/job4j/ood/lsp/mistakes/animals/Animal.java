package ru.job4j.ood.lsp.mistakes.animals;

public class Animal {
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean isOld() {
        return age > 20;
    }
}