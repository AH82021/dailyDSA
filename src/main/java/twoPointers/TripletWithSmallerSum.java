package twoPointers;
/*
Given an array arr of unsorted numbers and a target sum,
count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 Write a function to return the count of such triplets.
 Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose
 sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 */
public class TripletWithSmallerSum {
    public static int search(int[] arr, int target){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += searchPair(arr, target -arr[i],i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first +1;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] < targetSum) {
                count += right - left;
                left++;
            } else {
                right --;
            }

        }
        return count;
    }


}
