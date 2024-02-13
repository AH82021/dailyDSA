
import java.util.*;

/*
  You are working on a logic game made up of a series of puzzles.
 The first type of puzzle you settle on is "sub-Sudoku", a game where the player has to position the numbers 1. N on an N&N matrix.

 Your job is to write a function that, given an NxN matrix, returns true if every row and column contains the numbers 1. N
 The UI for the game does not do any validation on the numbers the player enters, so the matrix can contain any signed integer.

         grid1 = [[2, 3, 1],
                 [1, 2, 3],
                 [3,2,1] ];
 numbers(1,2,3)
     -> True (A grid of size 3: every row and column contains the contain the numbers 1,2 and 3)
 grId2 = [[1, 2, 3],
          [3, 2, 1],
         [3,1,2] ];


 → False (The first column is missing the value 2. It should
 contain the numbers 1,2 and 3 Similarly, the second column is missing the value


 */

 /*
 /*
 * Define the Function: Create a function isSubSudoku that takes a 2D integer array as input.
 * Check Rows: Loop through each row and check if it contains all numbers from 1 to N without duplicates.
 * Check Columns: Loop through each column and do the same check as for the rows.
 * Return Result: If both checks pass, return true. If either fails, return false.
 * Here's an example of how the code would look like
 *
  */

public class SudokuChecker {

    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 3, 1},
                {1, 2, 3},
                {3, 1, 2},
        };


        // O N^2 for time complexity
        // O(N) space complexity

        System.out.println(isSubSudoku(grid1)); // Expected to be true
        // Test other grids...
    }

    public static boolean isSubSudoku(int[][] grid) {
        int size = grid.length;

        // Check rows
        for (int[] row : grid) {

            if (!containsAllNumbers(row, size)) return false;
        }

        // Check columns
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = grid[row][col];
            }
            if (!containsAllNumbers(column, size)) return false;
        }

        return true;
    }

    private static boolean containsAllNumbers(int[] checkArray, int size) {

        Set<Integer> numbers = new HashSet<>();
        for (int num : checkArray) {
            // Only consider numbers between 1 and size (inclusive)
            if (num >= 1 && num <= size) {
                if (numbers.contains(num)) {
                    // Duplicate number found
                    return false;
                }
                numbers.add(num);
            } else {
                // Number out of valid range found
                return false;
            }
        }
        return numbers.size() == size;
    }
}
