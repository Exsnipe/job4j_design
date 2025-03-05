package ru.job4j.algo;

import java.util.*;
import java.util.stream.Collectors;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> listOfLists = convertToList(intervals);

        for (int index = 0; index < listOfLists.size(); index++) {
            if (index == listOfLists.size() - 1) {
                break;
            }
            if (listOfLists.get(index).get(1) >= listOfLists.get(index + 1).get(0)) {
                listOfLists.get(index).set(1, listOfLists.get(index + 1).get(1));
                listOfLists.remove(index + 1);
                index--;
            }
        }
        int[][] result = new int[listOfLists.size()][2];
        int index = 0;
        for (List<Integer> list : listOfLists) {
            result[index][0] = list.get(0);
            result[index][1] = list.get(1);
            index++;
        }
        return result;
    }

    private List<List<Integer>> convertToList(int[][] twoDimensionalArray) {
        return Arrays.stream(twoDimensionalArray)
                .map(array -> Arrays.asList(array[0], array[1]))
                .sorted(Comparator.comparingInt(innerList -> innerList.get(0)))
                .collect(Collectors.toList());
    }
}
