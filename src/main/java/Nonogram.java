import java.util.ArrayList;
import java.util.List;

/**
  A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and an instruction for each row and each column.
  The player has to color each row and column using the corresponding instruction. Each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.
   +-------------------+
   |  W   W   W   W    |
   |  B   W   W   W    |
   |  B   W   B   B    |
   |  W   W   B   W    |
   |  B   B   W   W    |
    +-------------------+
  17 For each row and column, the corresponding instruction gives the lengths of contiguous runs of black ('B') cells.
  For example, the instruction [ 2, 1 ] for a specific row indicates that there
  must be a run of two black cells, followed later by another fun of one black cell, and the rest of the row is filled with white cells.
   These are valid solutions: I w, B, B, w, B 1 and [ B, B, W, w, B 1 and also [ B, B, W, B, W ]
  This is not valid: [W, B, W, B, B I since the runs are not in the correct order.
  This is not valid: [W, B, B, B, W I since the two runs of Bs are not separated by Ws.
  Your job is to write a function to validate a possible solution against a set of instructions.

  Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of
  instructions match.
  Example solution matrix:
  validateNonogran(matrixi, rows1_1, columns1-1) => True

 * To solve this challenge, a function needs to be written that takes a character matrix representing a player's solution,
 * an array of row instructions, and an array of column instructions. It should return true if the player's solution matches the instructions for both rows and columns, and false otherwise.
 *
 * Here is a step-by-step approach and a potential Java function to solve this problem:
 *
 * Parse Instructions: Create a method to parse the instructions into a format that can be easily compared with the solution matrix.
 * Validate Rows: Write a method that validates each row of the matrix against the row instructions.
 * Validate Columns: Write a method that validates each column of the matrix against the column instructions.
 * Combine Validations: In the main validation method, combine the row and column validations to return the final result.
 */


public class Nonogram {



        public static boolean validateNonogram(char[][] matrix, int[][] rowsInstructions, int[][] columnsInstructions) {
            // Check each row
            for (int i = 0; i < matrix.length; i++) {
                // I crete a prive method to vlalidate
                if (!validateLine(matrix[i], rowsInstructions[i])) {
                    return false;
                }
            }

            // Check each column
            for (int i = 0; i < matrix[0].length; i++) {
                char[] column = extractColumn(matrix, i);
                if (!validateLine(column, columnsInstructions[i])) {
                    return false;
                }
            }

            return true;
        }

        private static boolean validateLine(char[] line, int[] instructions) {
            // Convert the line into a list of runs (consecutive 'B' cells)
            // create
            List<Integer> runs = calculateRuns(line);

            // Compare the list of runs with the instructions
            if (runs.size() != instructions.length) {
                return false;
            }
            for (int i = 0; i < runs.size(); i++) {
                if (runs.get(i) != instructions[i]) {
                    return false;
                }
            }
            return true;
        }

        private static List<Integer> calculateRuns(char[] line) {
            List<Integer> runs = new ArrayList<>();
            int currentRun = 0;
            for (char cell : line) {
                if (cell == 'B') {
                    currentRun++;
                } else if (currentRun > 0) {
                    runs.add(currentRun);
                    currentRun = 0;
                }
            }
            if (currentRun > 0) {
                runs.add(currentRun);
            }
            return runs;
        }
// I will need another private method
        private static char[] extractColumn(char[][] matrix, int columnIndex) {
            char[] column = new char[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][columnIndex];
            }
            return column;
        }

        public static void main(String[] args) {
            char[][] matrix1 = { {2, 3, 1},
                    {1, 2, 3},
                    {3,2,1 } };
            int[][] rows1 = { /* ... */};
            int[][] columns1 = { /* ... */ };

            System.out.println("Validation result: " + validateNonogram(matrix1, rows1, columns1));
            // Output: Validation result: true or false based on the matrix and instructions
        }
        //
    }


