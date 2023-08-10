package ru.job4j.kiss;

import java.util.Comparator;

public class Comparator1 implements Comparator<Model1> {
    @Override
    public int compare(Model1 o1, Model1 o2) {
        int comp = Integer.compare(o1.getAnInt(), o2.getAnInt());
        return comp == 0 ? Character.compare(o1.getaChar(), o2.getaChar()) : comp;
    }
}
