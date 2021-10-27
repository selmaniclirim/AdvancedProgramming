package labTwo.Matrixes;

import java.io.InputStream;
import java.util.Scanner;

public class MatrixReader {
    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner scanner = new Scanner(input);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[] myArray = new double[rows * columns];
        for(int i= 0; i < rows *columns; i++) {
            myArray[i] = scanner.nextDouble();
        }
        DoubleMatrix doubleMatrix = new DoubleMatrix(myArray, rows, columns);
        return doubleMatrix;
    }
}
