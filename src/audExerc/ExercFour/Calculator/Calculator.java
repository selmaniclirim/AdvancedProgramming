package audExerc.ExercFour.Calculator;

public class Calculator {
    private double result;

    public Calculator() {
        this.result = 0.00;
    }

    public String init() {
        return String.format("result = %.2f", result);
    }

    public double getResult() {
        return result;
    }

    public String operation(double number, char operator) throws UnknownOperatorException {
        if (operator == '*') {
            result *= number;
        } else if (operator == '/') {
            result /= number;
        } else if (operator == '+') {
            result += number;
        } else if (operator == '-') {
            result -= number;
        } else
            throw new UnknownOperatorException(operator);

        return String.format("result %c %.2f = %.2f", operator, number, result);
    }

    @Override
    public String toString() {
        return String.format("updated result = %.2f", result);
    }
}
