package ru.job4j.kiss;

import java.util.Objects;

public class Model1 {
    private final int anInt;
    private final char aChar;

    public Model1(int a, char b) {
        this.anInt = a;
        this.aChar = b;
    }

    public int getAnInt() {
        return anInt;
    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model1 model1 = (Model1) o;
        return anInt == model1.anInt && aChar == model1.aChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, aChar);
    }
}
