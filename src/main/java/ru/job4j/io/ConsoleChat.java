package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> phrases = new ArrayList<>();
    private List<String> log = new ArrayList<>();
    private String consoleInput;
    private boolean writeLogFlag = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        phrases = readPhrases();
        System.out.println(phrases.size());
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                consoleInput = scanner.nextLine();
                log.add(consoleInput);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           if (STOP.equals(consoleInput)) {
               writeLogFlag = false;
           }
           if (CONTINUE.equals(consoleInput)) {
               writeLogFlag = true;
           }
           if (writeLogFlag) {
               String answer = phrases.get((int) (Math.random() * phrases.size()));
               System.out.println(answer);
               log.add(answer);
            }
        } while (!OUT.equals(consoleInput));
        saveLog(log);
    }

    private List<String> readPhrases() {
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(phrases::add);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            log.forEach(writer::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\test\\log.txt", "C:\\test\\phrases.txt");
        cc.run();
    }
}
