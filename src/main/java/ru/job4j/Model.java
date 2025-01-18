package ru.job4j;

public class Model {
    private int top;
    private double num;
    private String line;
    private boolean conditio;

    public Model(int top, double num, String line, boolean conditio) {
        this.top = top;
        this.num = num;
        this.line = line;
        this.conditio = conditio;
    }

    public int getTop() {
        return top;
    }

    public double getNum() {
        return num;
    }

    public String getLine() {
        return line;
    }

    public boolean isConditio() {
        return conditio;
    }
}
