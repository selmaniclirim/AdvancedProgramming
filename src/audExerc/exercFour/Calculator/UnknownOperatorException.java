package audExerc.exercFour.Calculator;

public class UnknownOperatorException extends Exception {
    public UnknownOperatorException(char operator) {
        super(String.format("%c is an unknown operator!", operator));
    }
}
