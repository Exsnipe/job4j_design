package ru.job4j.gc;

import java.util.List;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class SoftDemo {
    public static void main(String[] args) {
        //example1();
        example2();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 50_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() {
                    System.out.println("Object removed");
                }
            }));
        }
        System.gc();
        int liveObjects = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObjects++;
            }
        }
        System.out.println(liveObjects);
    }
}
