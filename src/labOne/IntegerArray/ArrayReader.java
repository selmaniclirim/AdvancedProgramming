package labOne.IntegerArray;

import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {
    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner scanner = new Scanner(input);
        int arrayLength = scanner.nextInt();
        int[] myArray = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++) {
            myArray[i] = scanner.nextInt();
        }
        return new IntegerArray(myArray);
    }
}
