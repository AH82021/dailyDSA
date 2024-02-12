package twoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 Given an array with positive numbers and a target number,
 find all of its contiguous subarrays whose product is less than the target number.
 Input: [2, 5, 3, 10], target=30
 Output: [2], [5], [2, 5], [3], [5, 3], [10]
 Explanation: There are six contiguous subarrays whose product is less than the target.
 Input: [8, 2, 6, 5], target=50
 Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 Explanation: There are seven contiguous subarrays whose product is less than the target.


 Time complexity #
 The main for-loop managing the sliding window takes

 O(N) but creating subarrays can take up to

 O(N^2) in the worst case. Therefore overall, our algorithm will take )
 O(N^3).

 Space complexity #
 Ignoring the space required for the output list, the algorithm runs in
 O(N) space which is used for the temp list.

 Can you try estimating how much space will be required for the output list?
 The worst case will happen when every subarray has a product less than the target!

 So the question will be, how many contiguous subarray an array can have?

 It is definately not all Permutations of the given array, is it all Combinations of the given array?
 It is not all the Combinations of all elements of the array!

 For an array with distinct elements, finding all of its contiguous subarrays is like finding the number of ways to choose two indices i and j in the array such that i <= j.

 If there are a total of n elements in the array, here is how we can count all the contiguous subarrays:

 When i = 0, j can have any value from ‘0’ to ‘n-1’, giving a total of ‘n’ choices.
 When i = 1, j can have any value from ‘1’ to ‘n-1’, giving a total of ‘n-1’ choices.
 Similarly, when i = 2, j can have ‘n-2’ choices.
 …
 …
 When i = n-1, j can only have ‘1’ choice.
 Let’s combine all the choices:
 n + (n-1) + (n-2) + ... 3 + 2 + 1
 Which gives us a total of: n∗(n+1)/2

 So, at the most, we need a space of
 O(n^2) for all the output lists.

 */

public class SubArraysWthProductLessThanATarget {
    public static List<List<Integer>> findSubArrays(int[] arr, int target){
        List<List<Integer>> subArrays = new ArrayList<>();
        int product = 1;
        int left = 0;

        for(int right = 0; right < arr.length; right++){
            product *=arr[right];
            while (product >= target && left <arr.length) {
                product /= arr[left++];
            }
                List<Integer> tempList = new LinkedList<>();
                for (int i = right; i >=left ; i--) {
                    tempList.add(0,arr[i]);
                    subArrays.add(new ArrayList<>(tempList));
                }

        }

        return subArrays;


    }

//    public static void main(String[] args) {
//        int[] nums = {2, 5, 3, 10};
//        int target = 30;
//        System.out.println(findSubArrays(nums,target));
//    }

}
