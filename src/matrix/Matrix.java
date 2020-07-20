package matrix;

public interface Matrix {

    // returns number of rows
    public int getRows();

    // returns number of columns
    public int getCols();

    // returns cell value
    public int getColor(int row, int col);

    // set cell value
    public void setColor(int row, int col, int color);

    // checks if such a cell exist
    public boolean isInside(int row, int col);

    // returns the number of green neighbors of the given cell
    public int getNumberOfGreenNeighborsOfCell(int row, int col);

}
