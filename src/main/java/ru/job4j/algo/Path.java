package ru.job4j.algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Path {
    public static String simplify(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");
        for (String component : components) {
            if (component.equals("..")) {
                stack.pollLast();
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.add(component);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.isEmpty() ? "/" : result.toString();
    }

}
