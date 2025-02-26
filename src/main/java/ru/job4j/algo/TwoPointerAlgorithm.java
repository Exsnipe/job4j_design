package ru.job4j.algo;

public class TwoPointerAlgorithm {
    public static int[] squareSortedArray(int[] input) {
        int n = input.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int resultIndex = n - 1;
        while (left <= right) {
            if (Math.abs(input[left]) >= Math.abs(input[right])) {
                result[resultIndex] = input[left] * input[left];
                left++;
            } else {
                result[resultIndex] = input[right] * input[right];
                right--;
            }
            resultIndex--;
        }
        return result;
    }

}
