package Week1.Friday.CalculatorTesting;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(a);
    }
}
