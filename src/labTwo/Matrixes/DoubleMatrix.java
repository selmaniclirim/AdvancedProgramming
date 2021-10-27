package labTwo.Matrixes;

import java.util.Arrays;
import java.util.Objects;

//Immutable class
public class DoubleMatrix {
    private double[][] matrix;
    private int rows;
    private int columns;

    DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException {
        this.rows = m;
        this.columns = n;
        int x = a.length - 1;
        matrix = new double[this.rows][this.columns];
        if (this.rows * this.columns > a.length)
            throw new InsufficientElementsException();
        if(a.length > m * n) {
            for(int i = 0; i < this.rows; i++) {
                for(int j = 0; j < this.columns; j++) {
                    matrix[i][j] = a[x];
                    x--;
                }
            }
        } else {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    matrix[i][j] = a[i * this.columns + j];
                }
            }
        }

    }

    public String getDimensions() {
        return String.format("[%d x %d]", rows, columns);
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        double biggestElem = 0.0;
        if (row > this.rows || row < 0)
            throw new InvalidRowNumberException();
        for (int i = 0; i < columns; i++) {
            if (matrix[row - 1][i] > biggestElem)
                biggestElem = matrix[row - 1][i];
        }
        return biggestElem;
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        System.out.println("All elements of matrix are: " + this);
        double biggestElem = 0.0;
        System.out.println("Total rows are: " + rows());
        System.out.println("Function got called by column: " + column);
        if (column > this.columns || column < 0)
            throw new InvalidColumnNumberException();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("I now is: " + i);
            System.out.println("Value of matrix[i][column-1] is: " + matrix[i][column-1]);
            if (matrix[i][column - 1] > biggestElem) {
                System.out.println("Bigger element then " + biggestElem + " is: " + matrix[i][column - 1]);
                biggestElem = matrix[i][column - 1];
            }
            System.out.println("Biggest element now is: " + biggestElem);
        }
        return biggestElem;
    }

    public double sum() {
        double totalSum = 0.0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++){
                totalSum += this.matrix[i][j];
            }
        }
        return totalSum;
    }

    public double[] toSortedArray() {
        double[] ascSortedArray = new double[rows * columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                ascSortedArray[i * this.columns + j] = matrix[i][j];
            }
        }
        Arrays.sort(ascSortedArray);
        double[] descSortedArray = new double[rows * columns];
        for(int i = 0; i < ascSortedArray.length; i++) {
            descSortedArray[i] = ascSortedArray[ascSortedArray.length -1 - i];
        }
        return descSortedArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stringBuilder.append(String.format("%.2f", matrix[i][j]));
                if(j != columns - 1)
                    stringBuilder.append("\t");
            }
            if(i != rows - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return rows == that.rows && columns == that.columns && Arrays.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
