package ru.job4j.algo;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentIndex;
        int gasRemaining;
        for (int i = 0; i < gas.length; i++) {
            currentIndex = i;
            gasRemaining = gas[currentIndex];
            while (gasRemaining >= cost[currentIndex]) {
                gasRemaining -= cost[currentIndex];
                if (currentIndex == gas.length - 1) {
                    currentIndex = 0;
                } else {
                    currentIndex++;
                }
                gasRemaining += gas[currentIndex];
                if (i == currentIndex) {
                    return i;
                }
            }
        }
        return -1;
    }
}
