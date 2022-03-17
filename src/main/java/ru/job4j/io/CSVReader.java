package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        validate(argsName);
        String currentLine = "";
        String[] cells;
        List<String> out = new ArrayList<>();
        List<Integer> listIndex = new ArrayList<>();
        Path path = Paths.get(argsName.get("path"));
        try (Scanner scanner = new Scanner(path)) {
            if (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
            }
            cells = currentLine.split(argsName.get("delimiter"));
            String[] filters = argsName.get("filter").split(",");
            StringBuilder stringBuilder = new StringBuilder();
            for (String filter : filters) {
                stringBuilder.append(filter).append(";");
            }
            out.add(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
            for (int index = 0; index < cells.length; index++) {
                for (String filter : filters) {
                    if (filter.equals(cells[index])) {
                        listIndex.add(index);
                    }
                }
            }
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                cells = currentLine.split(argsName.get("delimiter"));
                stringBuilder = new StringBuilder();
                for (int index : listIndex) {
                    if (index < cells.length) {
                        stringBuilder.append(cells[index]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                out.add(stringBuilder.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if ("stdout".equals(argsName.get("out"))) {
            for (String line : out) {
                System.out.println(line);
            }
        } else {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(argsName.get("out")))) {
                for (String str : out) {
                    writer.println(str);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private static void validate(ArgsName argsName) {
        if (argsName.get("path")  == null || argsName.get("delimiter") == null
                || argsName.get("out") == null || argsName.get("filter") == null || argsName.size() != 4) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(ArgsName.of(args));
    }
}
