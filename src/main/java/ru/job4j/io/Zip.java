package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validate(ArgsName name) throws IllegalArgumentException {
        File dir = new File(name.get("d"));
        name.get("e");
        name.get("o");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName keys = ArgsName.of(args);
        zip.validate(keys);
        List<Path> list = Search.search(Paths.get(keys.get("d")), path -> !path.toFile()
                .getName().endsWith(keys.get("e")));
        List<File> files = new ArrayList<>();
        for (Path path : list) {
            files.add(path.toFile());
            System.out.println(path.toFile().getName());
        }
        zip.packFiles(files, new File(keys.get("o")));
    }
}
