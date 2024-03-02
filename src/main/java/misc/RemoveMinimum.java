package misc;

import java.util.Arrays;


public class RemoveMinimum {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 1, 2, 3, 4};

        int[] result1 = removeMinAndFirstOccurrence(arr1);
        int[] result2 = removeMinAndFirstOccurrence(arr2);

        System.out.println(Arrays.toString(result1)); // Output: [2, 3, 4]
        System.out.println(Arrays.toString(result2)); // Output: [1, 2, 3, 4]
    }

    public static int[] removeMinAndFirstOccurrence(int[] arr) {
        // Find the minimum value in the array
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        // Create a new array with the minimum value removed (only the first occurrence)
        int[] result = new int[arr.length - 1];
        int j = 0;
        boolean minRemoved = false;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIndex && !minRemoved) {
                minRemoved = true;
                continue;
            }
            result[j++] = arr[i];
        }

        return result;
    }
}

