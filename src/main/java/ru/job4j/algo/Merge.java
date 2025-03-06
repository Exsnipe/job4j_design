package ru.job4j.algo;

import java.util.Arrays;

public class Merge {
    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = Arrays.copyOfRange(array, 0, n / 2);
            int[] right = Arrays.copyOfRange(array, n / 2, n);
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        boolean leftIsMax = left.length > right.length;
        for (int index = 0; index < result.length; index++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                result[index] = left[leftIndex] < right[rightIndex] ? left[leftIndex++] : right[rightIndex++];
                continue;
            }
            if (leftIsMax) {
                result[index] = left[leftIndex++];
            } else {
                result[index] = right[rightIndex++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] left = {5, 7, 90, 110};
        int[] right = {2, 19, 56, 78};
        int[] result = merge(left, right);
        Arrays.stream(result).forEach(System.out::println);
    }
}
