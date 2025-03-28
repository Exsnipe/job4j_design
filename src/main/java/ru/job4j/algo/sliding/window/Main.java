package ru.job4j.algo.sliding.window;

import java.util.*;

public class Main {
    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[] {-1, -1};
        }
        intervals.sort(Comparator.comparingInt(Interval::getStart));
        int maxStart = -1;
        int maxEnd = -1;
        int macInterval = 0;
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(Interval::getEnd));
        for (Interval interval : intervals) {
            while (!queue.isEmpty() && queue.peek().getEnd() < interval.getStart()) {
                queue.poll();
            }
            queue.offer(interval);
            if (queue.size() > macInterval) {
                macInterval = queue.size();
                maxStart = interval.getStart();
                maxEnd = queue.peek().getEnd();
            }
        }
        return new int[] {
                maxStart, maxEnd
        };
    }

    private static boolean isIntervalsCrossed(Interval first, Interval second) {
        return first.getEnd() > second.getStart() && first.getStart() < second.getEnd();
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(8, 9));
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(el -> el.getEnd()));
        queue.addAll(intervals);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}