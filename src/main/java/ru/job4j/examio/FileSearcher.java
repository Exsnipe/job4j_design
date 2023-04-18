package ru.job4j.examio;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

import static ru.job4j.examio.DirectoryWalker.searchFiles;

public class FileSearcher {
    public static void main(String[] args) {
        Map<String, String> keys = Validator.validate(args[0]);
        List<Path> result = searchFiles(keys.get("-d"), keys.get("-t"), keys.get("-n"));
        System.out.println(result);
        try (FileWriter writer = new FileWriter(keys.get("-o"))) {
           for (Path file : result) {
               writer.write(file.toFile().getAbsolutePath() + System.lineSeparator());
           }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
