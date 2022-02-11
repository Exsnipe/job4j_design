package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
           AtomicBoolean started = new AtomicBoolean(false);
            reader.lines()
                   .filter(
                           line -> {
                               String[] divided = line.split(" ", 2);
                               if (!started.get() && ("500".equals(divided[0]) || "400".equals(divided[0]))) {
                                   started.set(true);
                                   return true;
                               }
                               if (started.get() && ("200".equals(divided[0]) || "300".equals(divided[0]))) {
                                   started.set(false);
                                   return true;
                               }
                               return  false;
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}