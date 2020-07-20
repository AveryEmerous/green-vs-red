import matrix.Matrix;
import matrix.MatrixImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reads matrix size
        String[] inputMatrixParams = scanner.nextLine().split(",\\s+");
        int cols = Integer.parseInt(inputMatrixParams[0]);
        int rows = Integer.parseInt(inputMatrixParams[1]);

        // initialization and matrix filling
        Matrix matrix = new MatrixImpl(rows, cols);
        fillMatrix(matrix, scanner);

        // reads coordinates of the watched cell and number of turns
        String[] specialCellInput = scanner.nextLine().split(",\\s+");
        int specialCellCol = Integer.parseInt(specialCellInput[0]);
        int specialCellRow = Integer.parseInt(specialCellInput[1]);
        int turns = Integer.parseInt(specialCellInput[2]);

        // validates coordinates of the special cell
        if (!isValid(specialCellRow, specialCellCol, matrix)) {
            System.out.println("Wrong coordinates for the special cell");
            System.exit(0);
        }

        // initialization a variable that tracks special cell and checks if it is green
        int specialCellGreenCount = 0;
        if (matrix.getColor(specialCellRow, specialCellCol) == 1) {
            specialCellGreenCount++;
        }


        for (int i = 0; i < turns; i++) {
            Matrix updatedMatrix = nextGeneration(matrix);

            // copies a new generation matrix
            for (int row = 0; row < matrix.getRows(); row++) {
                for (int col = 0; col < matrix.getCols(); col++) {
                    matrix.setColor(row, col, updatedMatrix.getColor(row, col));
                }
            }

            // checks if it is green
            if (matrix.getColor(specialCellRow, specialCellCol) == 1) {
                specialCellGreenCount++;
            }
        }

        // prints the result
        System.out.printf("Result: %d", specialCellGreenCount);
    }

    // a method that creates the next generation
    public static Matrix nextGeneration(Matrix matrix) {
        Matrix updatedMatrix = new MatrixImpl(matrix.getRows(), matrix.getCols());

        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getCols(); col++) {

                int greenNeighbors = matrix.getNumberOfGreenNeighborsOfCell(row, col);

                if (matrix.getColor(row, col) == 0) {
                    if (greenNeighbors == 3 || greenNeighbors == 6) {
                        updatedMatrix.setColor(row, col, 1);
                    } else {
                        updatedMatrix.setColor(row, col, 0);
                    }
                } else {
                    if (greenNeighbors == 2 || greenNeighbors == 3 || greenNeighbors == 6) {
                        updatedMatrix.setColor(row, col, 1);
                    } else {
                        updatedMatrix.setColor(row, col, 0);
                    }
                }
            }
        }

        return updatedMatrix;
    }

    // a method that validates coordinates for a special cell
    public static boolean isValid(int row, int col, Matrix matrix) {
        return row < matrix.getRows() && row >= 0 && col < matrix.getCols() && col >= 0;
    }

    // a method that fills the matrix with colors for every cell
    public static void fillMatrix(Matrix matrix, Scanner scanner) {
        for (int row = 0; row < matrix.getRows(); row++) {
            String colors = scanner.nextLine();
            for (int col = 0; col < matrix.getCols(); col++) {
                matrix.setColor(row, col, Integer.parseInt(String.valueOf(colors.charAt(col))));
            }
        }
    }
}
