package cp1;
/*
You are given a two-dimensional square matrix matzix and an integer turns.
 Your task is to rotate the given matrix "over diagonals" turns times and return the resulting matrix.
  The process of rotating is described below.
RULES
The elements on the two main diagonals stay the same after rotating.
 but the four segments divided by these diagonals are rotated to change places in a clockwise direction.
 */

public class MatrixRotator {


    public static int[][] solution(int[][] matrix, int turns) {
        int n = matrix.length;
        turns = turns % 4; // As every 4 turns will bring the matrix back to the original state.

        for (int t = 0; t < turns; t++) {
            // Temporary arrays to hold the four segments
            int[] topRight = new int[n / 2];
            int[] bottomRight = new int[n / 2];
            int[] bottomLeft = new int[n / 2];
            int[] topLeft = new int[n / 2];

            // Filling the temporary arrays with the respective segments
            for (int i = 0; i < n / 2; i++) {
                topRight[i] = matrix[i][n - i - 1];
                bottomRight[i] = matrix[n - i - 1][n - i - 1];
                bottomLeft[i] = matrix[n - i - 1][i];
                topLeft[i] = matrix[i][i];
            }

            // Rotating the segments clockwise
            for (int i = 0; i < n / 2; i++) {
                matrix[i][n - i - 1] = topLeft[i];
                matrix[n - i - 1][n - i - 1] = topRight[i];
                matrix[n - i - 1][i] = bottomRight[i];
                matrix[i][i] = bottomLeft[i];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int turns = 1; // the runt should be [

        // ]

        matrix = solution(matrix, turns);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}