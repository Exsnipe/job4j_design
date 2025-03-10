package ru.job4j.algo;

import java.util.Arrays;

public class Merge {
    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int index = 0; index < result.length; index++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                result[index] = left[leftIndex]
                        < right[rightIndex] ? left[leftIndex++] : right[rightIndex++];
            }
        }
        if (leftIndex < left.length) {
            System.arraycopy(left, leftIndex, result,
                    result.length - (left.length - leftIndex), left.length - leftIndex);

        }
        if (rightIndex < right.length) {
            System.arraycopy(right, rightIndex, result,
                    result.length - (right.length - rightIndex), right.length - rightIndex);
        }
        return result;
    }
}
