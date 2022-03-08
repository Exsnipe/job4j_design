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
    private Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        FileProperty currentFile = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!map.containsKey(currentFile)) {
            map.put(currentFile, new ArrayList<>());
        }
        map.get(currentFile).add(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    public void printFile() {
        for (FileProperty curFile : map.keySet()) {
            List<Path> list = map.get(curFile);
            if (list.size() > 1) {
                for (Path path : list) {
                    System.out.println(path);
                }
            }
        }
    }
}
