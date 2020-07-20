package matrix;

public class MatrixImpl implements Matrix {

    private final int rows;
    private final int cols;
    private int[][] matrix;

    public MatrixImpl(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getColor(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public void setColor(int row, int col, int color) {
        matrix[row][col] = color;
    }

    @Override
    public boolean isInside(int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[row].length && col >= 0;
    }

    @Override
    public int getNumberOfGreenNeighborsOfCell(int row, int col) {
        int count = 0;

        if (isInside(row - 1, col - 1)) {
            if (matrix[row - 1][col - 1] == 1) {
                count++;
            }
        }
        if (isInside(row - 1, col)) {
            if (matrix[row - 1][col] == 1) {
                count++;
            }
        }
        if (isInside(row - 1, col + 1)) {
            if (matrix[row - 1][col + 1] == 1) {
                count++;
            }
        }
        if (isInside(row, col - 1)) {
            if (matrix[row][col - 1] == 1) {
                count++;
            }
        }
        if (isInside(row, col + 1)) {
            if (matrix[row][col + 1] == 1) {
                count++;
            }
        }
        if (isInside(row + 1, col - 1)) {
            if (matrix[row + 1][col - 1] == 1) {
                count++;
            }
        }
        if (isInside(row + 1, col)) {
            if (matrix[row + 1][col] == 1) {
                count++;
            }
        }
        if (isInside(row + 1, col + 1)) {
            if (matrix[row + 1][col + 1] == 1) {
                count++;
            }
        }

        return count;
    }
}
