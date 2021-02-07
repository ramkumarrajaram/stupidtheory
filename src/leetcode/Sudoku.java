package leetcode;

public class Sudoku {

    public static void main(String[] args) {
        int[][] sudokuGrid = {
                        {5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}
                };

        Sudoku sudoku = new Sudoku();

        boolean solveSudoku = sudoku.solveSudoku(sudokuGrid);

        if (solveSudoku) {
            for (int[] ints : sudokuGrid) {
                System.out.print("[");
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.print("]");
                System.out.println();
            }
        } else {
            System.out.println("Seems like an issue with the input");
        }
    }

    private boolean solveSudoku(int[][] matrix) {
        int row, column = 0;
        boolean isAssigned  = true;

        for(row = 0; row < matrix.length; row++) {
            for(column = 0; column < matrix[row].length; column++) {
                if(matrix[row][column] == 0) {
                    isAssigned = false;
                    break;
                }
            }

            if(!isAssigned) {
                break;
            }
        }

        if(isAssigned) {
            return true;
        }

        for (int number = 0; number <= 9; number++) {
            if(isValidPosition(row, column, matrix, number)) {
                matrix[row][column] = number;
                if(solveSudoku(matrix)) {
                    return true;
                }

                matrix[row][column] = 0;
            }
        }
        return false;
    }

    private boolean isValidPosition(int row, int column, int[][] matrix, int number) {
        for (int col = 0; col < matrix.length; col++) {
            if(matrix[row][col] == number) {
                return false;
            }
        }

        for (int[] ints : matrix) {
            if (ints[column] == number) {
                return false;
            }
        }

        return usedInBox(matrix, row - (row % 3), column - (column % 3), number);
    }

    private boolean usedInBox(int[][] matrix, int boxStartRow, int boxStartCol, int number) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (matrix[row + boxStartRow][col + boxStartCol] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
