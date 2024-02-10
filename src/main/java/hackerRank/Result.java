package hackerRank;

import java.util.List;
import java.util.Map;

public class Result {
//    Given an array of integers, the goal is to make all the elements in the array have equal values by applying some number of operations. ALL
//
//    The rules of the operations are:
//
//      - To apply an operation, one needs to choose a prefix of the array and an integer x(x can be negative).
//    - In this operation, add x to each element inside this prefix.
//- The cost of this operation is /x/ (Absolute value of x).
//
//    For example, if the array is [1, 4, 2, 1] and the prefix of length 2 and x =-3 are chosen
 //    the array would now be [-2,1,2,1] and the cost of this operation is /x/ (Absolute value of x)

    public static int findMinimumCost(List<Integer> arr){
        int minCost =0;
        int n = arr.size();
        //the target value to match with last element of the array
        int target = arr.get(n -1);

        for (int i = n-2; i>=0 ; i--) {
            if(arr.get(i) != target){
                minCost += Math.abs(arr.get(i) - target);
                target = arr.get(i);
            }
        }
        return  minCost;
    }



}
