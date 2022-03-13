package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().map(s -> s + System.lineSeparator()).forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, String data) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path))) {
            writer.println(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./src/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
