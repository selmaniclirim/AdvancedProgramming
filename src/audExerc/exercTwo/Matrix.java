package audExerc.exercTwo;

public class Matrix {

    public static double sum(double[][] matrix) {
        double sum = 0;
        sum = getSum(matrix, sum);
        return sum;
    }

    public static double average(double[][] matrix) {
        return sum(matrix) / (matrix.length * matrix[0].length);
    }

    private static double getSum(double[][] matrix, double sum) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                sum += matrix[i][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[][] matrix = {{1,2,3,4}, {5,6,7,8}};
        System.out.println(sum(matrix) + "\n");
        System.out.println(average(matrix));
    }
}
