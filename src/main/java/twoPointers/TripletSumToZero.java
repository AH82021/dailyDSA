package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
]Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero
 */
public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] numbers){

        Arrays.sort(numbers);

        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        for (int i = 0; i < numbers.length -2; i++) {
            if(i>0 && numbers[i]==numbers[i-1])
                continue;
                searchPairs(numbers,-numbers[i],i+i,triplets);
        }

        return triplets;
    }

    private static void searchPairs(int[] numbers, int targetSum, int left, List<List<Integer>> triplets) {
 int right = numbers.length -1;
 while(left<right){
     int currentSum = numbers[left] + numbers[right];
     if(currentSum == targetSum){
         triplets.add(Arrays.asList(-targetSum,numbers[left],numbers[right]));
         left++;
         right --;
         while (left<right && numbers[left] == numbers[left -1])
             left++;
         while (left<right && numbers[right] == numbers[right+1]);
         right --;
     } else if (targetSum > currentSum) {
         left ++;
     } else
         right --;
 }

    }

    public static void main(String[] args) {
        int[] input = {-3, 0, 1, 2, -1, 1, -2};
        System.out.println(searchTriplets(input));
    }

}
