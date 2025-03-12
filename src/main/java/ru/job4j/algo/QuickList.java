package ru.job4j.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QuickList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
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
        T pivot = sequence.get(start);
        int left = start + 1;
        int right = end;
        while (true) {
            while (left < end && comparator.compare(sequence.get(left), pivot) < 0) {
                left++;
            }
            while (comparator.compare(sequence.get(right), pivot) > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(sequence, left++, right--);
        }
        swap(sequence, start, right);
        return right;
    }

    private static <T> void swap(List<T> sequence, int i, int j) {
        T temp = sequence.get(i);
        sequence.set(i, sequence.get(j));
        sequence.set(j, temp);
    }
}
