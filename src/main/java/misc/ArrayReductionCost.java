package misc;

import java.util.*;

public class ArrayReductionCost {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7};
        System.out.println("Total cost: " +findTotalCost(arr));
        ; // Example array


        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        System.out.println("sol 2");
        System.out.println("Hello" +findTotalCost(arr));


        System.out.println(findTotalCost(arr)); // Output should be 8

        int[] emptyArr = {};
        System.out.println(findTotalCost(emptyArr)); // Output should be 0

        int[] singleArr = {5};
        System.out.println(findTotalCost(singleArr)); // Output should be 0

        int[] duplicateArr = {5, 5, 5, 5};
        System.out.println(findTotalCost(duplicateArr)); // Output should be 4
    }

    public static int findTotalCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalCost = 0;

        // Add all elements to both min and max heaps
        for (int num : arr) {
            minHeap.offer(num);
            maxHeap.offer(num);
        }

        while (minHeap.size() > 1) {
            int min = minHeap.poll();
            int max = maxHeap.poll();

            // Remove the max element from minHeap and min element from maxHeap
            minHeap.remove(max);
            maxHeap.remove(min);

            int sum = min + max;
            // Calculate the cost of the operation
            int cost = (int) Math.ceil((double) sum / (max - min + 1));
            System.out.println(cost);
            totalCost += cost;

            // Add the sum back to both heaps
            minHeap.offer(sum);
            maxHeap.offer(sum);
        }

        return totalCost;
    }

}

//.file




