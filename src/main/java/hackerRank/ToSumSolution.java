package hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ToSumSolution {
    /*
1.) Iterate over every number in the array This can be done with a simple for loop.
2.) Calculate the complement. The complement is the other number that would sum to the target and can be calculated as target - num.
3.) Check if that complement is in our hash table If the complement is in the hash table then we can look up its index and we have our solution!
If it is not then we continue to search the array.
4.) Add the current number to our hash table The current number may sum up with another number that we have not yet evaluated.
We can store the number in the hash table as a key with the index as the value for future checks.
Time/Space Complexity
Time Complexity: O(n), where n is the size of the array. We iterate over every number in the array and the hash table lookup/add operations take constant time.
Space Complexity: O(n), where n is the size of the array. Our hash map stores every number in the input array.
    */

    public static int[] toSum(int[] arr, int target){
        //hash table that stores at which index the number is at
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        //    // 1. Iterate over every number in the array

        for (int i = 0; i < arr.length; i++) {
            // 2. Calculate the complement that would sum to our target
            int complment = target - arr[i];
            // // 3. Check if that complement is in our hash table
            if(numToIndex.containsKey(complment)){
                return  new int[]{numToIndex.get(complment),i};
            }
                  // 4. Add the current number to our hash table
            numToIndex.put(arr[i], i);

        }
 // in no pair found return {-1,}
        return new int[]{-1, -1};

    }
}
