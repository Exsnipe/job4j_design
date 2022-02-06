package ru.job4j.io;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       String[] lines = text.toString().split(System.lineSeparator());
        List<Integer> nums  = new ArrayList<>();
        for (String line : lines) {
            nums.add(Integer.parseInt(line));
        }
        for (int num : nums) {
            System.out.println("is number " + num + " even: " + (num % 2 == 0));
        }
    }
}
