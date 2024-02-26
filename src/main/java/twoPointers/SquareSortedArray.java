package twoPointers;

import java.util.Arrays;

/*
Given a sorted array,
 create a new array containing squares
 of all the number of the input array in the sorted order.
 Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
 */
public class SquareSortedArray {
    public static int[] getSquares(int[] array){
      int[] squares = new int[array.length];
      int heightSquaredIndex = array.length -1;
      int left =0;
      int right = array.length - 1;
      while (left < right){
          int leftSquare = array[left] * array[left];
          int rightSquare = array[right] * array[right];
          if(leftSquare > rightSquare){
              squares[heightSquaredIndex--] = leftSquare;
              left ++;

          } else {
              squares[heightSquaredIndex --] =rightSquare;
              right --;
          }
      }
      return  squares;
    }

    
}
