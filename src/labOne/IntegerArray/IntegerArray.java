package labOne.IntegerArray;

import java.util.Arrays;

public final class IntegerArray {
    private final int[] intArray;

    IntegerArray(int[] intArray) {
        this.intArray = Arrays.copyOf(intArray, intArray.length);
    }

    int length() {
        return intArray.length;
    }

    int getElementAt(int i) {
        return intArray[i];
    }
    int sum() {
        int sum = 0;
        for(int i: intArray)
            sum+= i;
        return sum;
    }
    double average() {
        double avg = 0;
        for(int i: intArray)
            avg+= i;
        avg /= intArray.length;
        return avg;
    }
    IntegerArray getSorted() {
        int[] sortedArray = Arrays.copyOf(intArray, length());
        Arrays.sort(sortedArray);
        return new IntegerArray(sortedArray);
    }
    IntegerArray concat(IntegerArray ia) {
        IntegerArray integerArray = new IntegerArray(Arrays.copyOf(this.intArray, intArray.length + ia.intArray.length));

        if (integerArray.intArray.length - this.intArray.length >= 0)
            System.arraycopy(ia.intArray, 0, integerArray.intArray, this.intArray.length, integerArray.intArray.length - this.intArray.length);
        return integerArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(intArray, that.intArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(intArray);
    }

    @Override
    public String toString() {
        return Arrays.toString(intArray);
    }
}
