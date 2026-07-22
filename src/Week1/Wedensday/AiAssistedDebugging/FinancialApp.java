package Week1.Wedensday.AiAssistedDebugging;

public class FinancialApp {
    public static double computeScore(int totalScore, int divisor) {
        // Validate divisor to enforce boundary checks instead of relying on catching ArithmeticException
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor must be non-zero");
        }
        return (double) totalScore / divisor;
    }

    public static void main(String[] args) {
        System.out.println("Processing report...");
        int divisor = 0; // example input

        // Validate before calling computeScore to avoid runtime errors
        if (divisor == 0) {
            System.out.println("Invalid divisor: 0. Please provide a non-zero divisor.");
        } else {
            double value = computeScore(100, divisor);
            System.out.println("Calculated Value: " + value);
        }
    }
}
