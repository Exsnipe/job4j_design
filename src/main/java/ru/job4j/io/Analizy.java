package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
           list = reader.lines()
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = "";
            boolean started = false;
            for (String code : list) {
                String[] divided = code.split(" ", 2);
                if (("500".equals(divided[0]) || "400".equals(divided[0])) && !started) {
                    started = true;
                    start = divided[1];
                }
                if (("200".equals(divided[0]) || "300".equals(divided[0])) && started) {
                    started = false;
                    out.println(start + ";" + divided[1] + ";");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("source.txt", "target.txt");
    }
}
