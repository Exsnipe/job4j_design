package ru.job4j.algo;

import java.util.Comparator;
import java.util.List;

public class QuickList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {

    }

    private static <T> void quickSort(List<T> sequence, int start,
                                      int end, Comparator<T> comparator) {
        if (start > end) {
            return;
        }
        int h = breakPartition(sequence, start, end, comparator);
        quickSort(sequence, start, h - 1, comparator);
        quickSort(sequence, h + 1, end, comparator);
    }

    private static <T> int breakPartition(List<T> sequence, int start,
                                          int end, Comparator<T> comparator) {
        return 0;
    }
}
