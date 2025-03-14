package ru.job4j.algo;

import java.util.Arrays;

public class Quick {
    public static void quickSort(int[] sequence) {
        quickSort(sequence, 0, sequence.length - 1);
    }

    private static void quickSort(int[] sequence, int start, int end) {
        if (start >= end) {
            return;
        }
        int h = breakPartition(sequence, start, end);
        quickSort(sequence, start, h - 1);
        quickSort(sequence, h + 1, end);
    }

    private static int breakPartition(int[] sequence, int start, int end) {
        int pivot = sequence[start];
        int left = start + 1;
        int right = end;
        while (true) {
            while (left < end && sequence[left] < pivot) {
                left++;
            }
            while (sequence[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(sequence, left++, right--);
        }
        swap(sequence, start, right);
        return  right;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {20, 109, -2, 11, 3, -2, -7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
