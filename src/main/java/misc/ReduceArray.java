package misc;

import java.util.PriorityQueue;
import java.util.List;
/*
Given an integer array, reduce the array to a single element.
In each operation, pick two indices i and j (where i #
J), and:
• append the value of alif + ali]to the array
• delete ali] and alif from the array
2
The cost of each operation is ali] + ali]. Find the minimum possible cost to reduce the array.
Example
Consider array [25,10,20]
• Pick 10 and 20, cost = 10+20 = 30, array' = [25,30]
• Pick 25 and 30, cost = 25+30 = 55, array" = [55]
*/

public class ReduceArray {
    public static int minimizeCost(List<Integer> arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr);
        int totalCost = 0;

        while (heap.size() > 1) {
            int cost = heap.poll() + heap.poll();
            totalCost += cost;
            heap.add(cost);
        }

        return totalCost;
    }
}