package misc;

public class RobotMovement {
    /*
     Imagine a board of size numrows & numcolumns with some lasers placed on it. These lasers are placed at coordinates specified
     in the two-dimensional array lasercoordinates, where lasercoordinates [i] is a two-element array containing coordinates for the center of the ith laser.
Lasers with a center in a cell (row, column destroy everything in the same row (i.e. rows with index row ) and the same column (i.e. columns with index column
RULES

Now imagine there is a robot at coordinates (currow, curcolumn) - The robot can only move in a straight line, either left, right, up, or down within this board. Your task is to count the maximum number of cells that the robot can safely move through (in any direction) before being destroyed by lasers
Note: You can assume that the initial cell is protected and lasers cannot destroy the robot there even if they cover this cell in their destruction area.
     */


    public static int solution(int numRows, int numColumns, int curRow, int curColumn, int[][] laserCoordinates) {
        int maxMoves = 0;

        // Check moves in each direction (up, down, left, right)
        for (int direction = 0; direction < 4; direction++) {
            int rowStep = 0;
            int colStep = 0;
            int movesInThisDirection = 0;  // Track moves for each direction separately

            // Define movement based on direction
            switch (direction) {
                case 0:  // Up
                    rowStep = -1;
                    break;
                case 1:  // Down
                    rowStep = 1;
                    break;
                case 2:  // Left
                    colStep = -1;
                    break;
                case 3:  // Right
                    colStep = 1;
                    break;
            }

            // Check moves in the chosen direction until a wall or laser is hit
            int newRow = curRow + rowStep;
            int newCol = curColumn + colStep;
            while (isValidCell(newRow, newCol, numRows, numColumns) && !isLaserHit(laserCoordinates, newRow, newCol)) {
                newRow += rowStep;
                newCol += colStep;
                movesInThisDirection++;
            }

            maxMoves = Math.max(maxMoves, movesInThisDirection);  // Update maxMoves with the longest direction
        }

        return maxMoves;  // Return the maximum moves across all directions
    }

        // Helper method to check if a cell is within board boundaries
    private static boolean isValidCell(int row, int col, int numRows, int numColumns) {
        return row >= 0 && row < numRows && col >= 0 && col < numColumns;
    }

    // Helper method to check if a cell is hit by a laser
    private static boolean isLaserHit(int[][] laserCoordinates, int row, int col) {
        for (int[] laser : laserCoordinates) {
            if (laser[0] == row || laser[1] == col) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int numRows = 8;
        int numColumns = 8;
        int curRow = 5;
        int curColumn = 3;
        int[][] laserCoordinates = {{1, 6}, {2, 8}}; // Adjusted to be within bounds

        System.out.println("Maximum safe cells: " + solution(numRows, numColumns, curRow, curColumn, laserCoordinates));
    }
}
