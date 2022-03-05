package ru.job4j.io;

import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class Search {
   public static void main(String[] args) throws IOException {
      if (args.length < 2 || !args[1].startsWith(".")) {
         throw new IllegalArgumentException("Wrong input parameters");
      }
      System.out.println(args[0] + " " + args[1]);
      Path root = Paths.get(args[0]);
      search(root, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
   }

   public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
      SearchFiles searcher = new SearchFiles(condition);
      Files.walkFileTree(root, searcher);
      return searcher.getListPath();
   }
}
