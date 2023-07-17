package ru.job4j;

public class StaticInvoke {
    public static void staticInv() {
        System.out.println("Static invoke");
    }

    public static void main(String[] args) {
        StaticInvoke.staticInv();
        StaticInvoke staticInvoke = new StaticInvoke();
    }
}
