package labOne.RomanConverter;

public class RomanConverter {
    /**
     * Roman to decimal converter
     *
     * @param n number in decimal format
     * @return string representation of the number in Roman numeral
     */
    public static String toRoman(int n) {
        // your solution here
        String romanNumber = "";
        int[] num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNum = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < num.length; i++) {
            while (n >= num[i]) {
                n -= num[i];
                romanNumber += romanNum[i];
            }
        }
        return romanNumber;
    }

}