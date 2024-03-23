package goldMan;

import java.util.Arrays;
import java.util.List;

public class Main {

    /*
    Consider an array of integers and a non-zero positive starting value x.
     A running sum is calculated by adding each element of the array to x consecutively.
     Determine the minimum value of x such that the running sum is at least 1 after every iteration.
     There is no value smaller than 5 that satisfies the condition.
A
arr = [3, -6, 5, -2, 1]
If the starting value is 4, running sums are [7, 1, 6, 4,
5]. This is the minimum starting value.
arr = [5]
The starting value of xis 1.
Examples
arr = [-4, 3, 2, 1]
Let starting value x = 5
Running sums:
5 + (-4) = 1
1 + 3=4
4+2=6
6 + 1 = 7.
There is no value smaller than 5 that satisfies the condition.
     */
    public static void main(String[] args) {
        System.out.println(minStart(Arrays.asList(-4, 3, 2, 1))); // Output: 5
        System.out.println(minStart(Arrays.asList(3, -6, 5, -2, 1))); // Output: 4
        // Output: 1
    }

    public static long minStart(List<Integer> arr) {
        long minSum = 0;
        long currentSum = 0;

        for (int j : arr) {
            currentSum += j;
            minSum = Math.min(minSum, currentSum);
        }

        // If minSum is negative, we need to start with a positive value that offsets it.
        // Otherwise, we can start with 1, since the array does not cause the sum to go below 1.
        return minSum < 0 ? 1 - minSum : 1;
    }
}

