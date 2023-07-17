package ru.job4j.gc;

public class StrongDemoModel {
    private int i;

    public StrongDemoModel(int i) {
        this.i = i;
    }

    @Override
    protected void finalize() {
        System.out.printf("removed %d" + System.lineSeparator(), this.i);
    }
}
