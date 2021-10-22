package audExerc.exercOne;

public class StructuralCode {
    /*
    Count all the numbers between a and b which are divisible with the sum of their digits
     */
    public static int myFunction(int a, int b) {
        int counter = 0;
        for(int i = a; i <= b; i++) {
            if(i%getSumOfDigits(i) == 0) {
                ++counter;
            }
        }
        return counter;
    }

    private static int getSumOfDigits(int n) {
        int sumOfDigits = 0;
        while(n >0){
            sumOfDigits+=(n %10);
            n /=10;
        }
        return sumOfDigits;
    }

    public static void main(String[] args) {

    }
}
