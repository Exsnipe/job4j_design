package ru.job4j.examio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryWalker {

    public static List<Path> searchFiles(String dir, String mode, String name) {
        List<Path> result = new ArrayList<>();
        Predicate<Path> condition = chooseMode(mode, name);
        try {
            Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<>() {
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (condition.test(file)) {
                        result.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }

    private static Predicate<Path> chooseMode(String mode, String name) {
        if ("name".equals(mode)) {
            return (p) -> p.toFile().getName().equals(name);
        }
        if ("mask".equals(mode)) {
            return (p) -> p.toFile().getAbsolutePath().matches(maskToRegex(name));
        }
        if ("regex".equals(mode)) {
            return (p) -> p.toFile().getAbsolutePath().matches(name);
        }
        return (p) -> p.toFile().getName().equals("");
    }

    private static String maskToRegex(String mask) {
        String regex = mask.replace(".", "\\.");
        regex = regex.replace("?", ".{1}");
        return regex.replace("*", ".*");
    }
}
