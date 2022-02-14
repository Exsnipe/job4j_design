package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
           AtomicBoolean started = new AtomicBoolean(false);
           AtomicBoolean rsl = new AtomicBoolean(false);
            reader.lines()
                   .filter(
                           line -> {
                               rsl.set(false);
                               String[] divided = line.split(" ", 2);
                               if (!started.get() && ("500".equals(divided[0]) || "400".equals(divided[0]))) {
                                   started.set(true);
                                   rsl.set(true);
                               }
                               if (started.get() && ("200".equals(divided[0]) || "300".equals(divided[0]))) {
                                   started.set(false);
                                   rsl.set(true);
                               }
                               return  rsl.get();
                           }
                   )
                    .forEach(
                            line -> {
                                if (started.get()) {
                                    out.print(line.split(" ", 2)[1] + ";");
                                } else {
                                    out.println(line.split(" ", 2)[1] + ";");
                                }
                            }
                    );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("source.txt", "target.txt");
    }
}