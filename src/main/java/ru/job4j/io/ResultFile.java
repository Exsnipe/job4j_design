package ru.job4j.io;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 9; i++) {
                out.write(("1 x " + i + " = " + i).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
