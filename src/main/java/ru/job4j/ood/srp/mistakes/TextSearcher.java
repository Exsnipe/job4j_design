package ru.job4j.ood.srp.mistakes;

import ru.job4j.list.List;

public interface TextSearcher {
    List<String> search(String regex, String text);

    void substitute(List<String> words, String text);
}
