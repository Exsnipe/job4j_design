package ru.job4j.algo;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int counter = 1;
            int j = i;
            while (nums[j] != nums[j + 1]) {
                counter++;
                if (counter == k) {
                    result[0] = i;
                    result[1] = j + 1;
                    return result;
                }
                j++;
            }
        }
        return null;
    }
}
