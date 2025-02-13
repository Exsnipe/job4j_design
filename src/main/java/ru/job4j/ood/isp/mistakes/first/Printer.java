package ru.job4j.ood.isp.mistakes.first;

import java.io.File;

public interface Printer {
    boolean connect(String url);

    void print(File file);

    File scan();
}
