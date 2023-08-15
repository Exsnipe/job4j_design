package ru.job4j.ood.srp.mistakes;

import ru.job4j.list.List;

public interface TextSearcher {
    public List<String> search(String regex, String text);

    public void substitute(List<String> words, String text);
}
