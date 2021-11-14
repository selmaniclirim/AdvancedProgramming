package FPExercises.F1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class F1Race {
    F1Driver[] drivers = new F1Driver[1];

    F1Race() {}

    void readResults(InputStream inputStream) throws IOException {
        F1Driver driver = new F1Driver("yes","yes","yes","yes");
        drivers = Arrays.copyOf(drivers, drivers.length + 1);
        drivers[0] = driver;
    }

    void printSorted(OutputStream outputStream) {
        System.out.println(drivers[0].toString());
    }
}
