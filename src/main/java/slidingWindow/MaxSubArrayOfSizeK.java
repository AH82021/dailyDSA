package slidingWindow;
/*
Given an array of positive numbers and a positive number ‘k’,
 find the maximum sum of any contiguous subarray of size ‘k’.
 Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSubArrayOfSizeK {
    /*
    A basic brute force solution will be to calculate the sum of all ‘k’ sized subarrays of the given array,
     to find the subarray with the highest sum. We can start from every index of the given array and add the
      next ‘k’ elements to find the sum of the subarray.
    The time complexity of the above algorithm will be
O(N∗K), where ‘N’ is the total number of elements in the given array
     */
    public static int findMaxSubArray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        // initialize the window sum by adding the first k elements
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        // slide the window from left to right
        for (int i = k; i < arr.length; i++) {
            // add the next element and subtract the first element from the window
            windowSum += arr[i] - arr[i - k];
            // update the maximum window sum
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /*
Subtract the element going out of the sliding window i.e., subtract the first element of the window.
Add the new element getting included in the sliding window i.e., the element coming right after the end of the window.
 */
    public static int findMinSubArrayOofN(int[] arr, int k){
        int windowSum =0;
        int maxSum =0;
        int windowStart =0;
        for (int windowEnd = 0; windowEnd <arr.length ; windowEnd++) {
            windowSum += arr[windowEnd];
            if(windowEnd>= k -1){
                maxSum = Math.max(maxSum,windowSum);
                windowSum -=arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray size k " + findMaxSubArray(new int[] {2,1,5,1,3,2},3));
        System.out.println("Maximum sum of a subarray size k " + findMinSubArrayOofN(new int[] {2,1,5,1,3,2},3));
    }

}
