package ru.job4j.algo;

import java.util.*;

public class SlidingMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            deque.offerLast(nums[i]);
        }
        List<Integer> range = new ArrayList<>(deque);
        Collections.sort(range);
        int i = k;
        int j = 0;
        if (k % 2 == 0) {
            result[j++] = (double) (range.get(k / 2) + range.get((k / 2) - 1)) / 2;
        } else {
            result[j++] = range.get(k / 2);
        }
        while (i < nums.length) {
            deque.pollFirst();
            deque.offerLast(nums[i++]);
            range.clear();
            range.addAll(deque);
            Collections.sort(range);
            if (k % 2 == 0) {
                result[j++] = (double) (range.get(k / 2) + range.get((k / 2) - 1)) / 2;
            } else {
                result[j++] = range.get(k / 2);
            }
        }
        return result;
    }
}
