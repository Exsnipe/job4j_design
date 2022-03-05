package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<Path, FileProperty> files = new HashMap<>();
    private List<Path> pathList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        files.put(file.toAbsolutePath(), new FileProperty(file.toFile().length(), file.toFile().getName()));
        return FileVisitResult.CONTINUE;
    }

    public void printFile() {
        List<Path> duplicates = new ArrayList<>();
        for (Path path : files.keySet()) {
            if (!pathList.contains(path)) {
                duplicates = files.keySet().stream()
                        .filter(f -> files.get(f).equals(files.get(path)))
                        .collect(Collectors.toList());
            }
            if (duplicates.size() > 1) {
                pathList.addAll(duplicates);
            }
        }
        for (Path path : pathList) {
            FileProperty curFile = files.get(path);
            System.out.println(curFile.getName() + " " + curFile.getSize());
        }
    }
}
