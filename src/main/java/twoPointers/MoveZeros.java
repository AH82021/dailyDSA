package twoPointers;

public class MoveZeros {
    /*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
     */
public void moveZeroes(int[]nums){
    int left =0;
    for (int right = 0; right < nums.length; right++) {
        if(nums[right] != 0){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left +=1;
        }
    }
    }
}
