package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Set<Integer> set = map.keySet();
        System.out.println(map);
        System.out.println(set);
        for (int index : set) {
            System.out.println(map.get(index));
        }
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }
}
