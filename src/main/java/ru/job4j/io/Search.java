package ru.job4j.io;

import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class Search {
   public static void main(String[] args) throws IOException {
      Path root = Paths.get(".");
      search(root, p -> p.toFile().getName().endsWith(".xml")).forEach(System.out::println);
   }

   public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
      SearchFiles searcher = new SearchFiles(condition);
      Files.walkFileTree(root, searcher);
      return searcher.getListPath();
   }
}
