package ru.job4j.ood.lsp.mistakes.animals;

import ru.job4j.ood.lsp.mistakes.animals.Animal;

public class Dog extends Animal {

    public Dog(int age) {
        super(age);
    }

    @Override
    public boolean isOld() {
        return age > 10;
    }
}
