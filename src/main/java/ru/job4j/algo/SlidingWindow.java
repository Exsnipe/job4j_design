package ru.job4j.algo;

public class SlidingWindow {
    public static int findMaxSum(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        System.out.println(max);
        int index = 1;
        int curSum = max;
        while (index + k - 1 < arr.length) {
            curSum = curSum - arr[index - 1] + arr[index + k - 1];
            max = Math.max(curSum, max);
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Максимальная сумма подмассива длиной " + k + " равна " + findMaxSum(arr, k));
    }
    //Максимальная сумма подмассива длиной 3 равна 24
}
