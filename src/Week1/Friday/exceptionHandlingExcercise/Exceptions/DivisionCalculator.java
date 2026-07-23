package Week1.Friday.exceptionHandlingExcercise.Exceptions;

public class DivisionCalculator {
    public static int divide(String numeratorStr, String denominatorStr) throws InvalidInputException{

        int numerator;
        int denominator;

        if (numeratorStr == null || denominatorStr == null
            || numeratorStr.trim().isEmpty() || denominatorStr.trim().isEmpty()) {
            throw new InvalidInputException("Input arguments cannot be null or empty");
        }
        try {
            numerator=Integer.parseInt(numeratorStr);
            denominator=Integer.parseInt(denominatorStr);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Inputs must be valid integers. Parsing failed");
        }

        try{
            int result=numerator/denominator;
            return result;
        } catch (ArithmeticException e) {
            throw new InvalidInputException("Division by zero is mathematically undefined.");
        }


    }

    public static void main(String[] args) {
        try {
            System.out.println(divide("100", "5"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[CALCULATOR] Execution cycle complete.");
        }

        try {
            System.out.println(divide("100", "0"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[CALCULATOR] Execution cycle complete.");
        }

        try {
            System.out.println(divide("abc", "5"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[CALCULATOR] Execution cycle complete.");
        }

        try {
            System.out.println(divide(null, "5"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[CALCULATOR] Execution cycle complete.");
        }

    }

}
