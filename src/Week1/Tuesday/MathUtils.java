package Week1.Tuesday;

public class MathUtils {

    public static void main(String[] args){


        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Is 7 prime: " + isPrime(7));
        System.out.println("Is 10 prime: " + isPrime(10));
        System.out.println("25 Celsius in Fahrenheit: " + celsiusToFahrenheit(25));
        System.out.println("Max of int array: " + findMax(new int[]{3, 7, 1, 9, 4}));
        System.out.println("Max of double array: " + findMax(new double[]{3.5, 7.2, 1.1, 9.9, 4.4}));
    }
    public static long factorial(int n){
        long product=1;
        for(int i=1; i<=n;i++){
            product=product*i;

        }
        return product;
    }

    public static boolean isPrime(int n){
        if (n<2) {return false;}

        for (int i=2; i<=Math.sqrt(n);i++){
            if (n%i==0) {
                return false
            ;}
        }

        return true;
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Warning: array is empty or null");
            return 0;
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static double findMax(double[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Warning: array is empty or null");
            return 0;
        }
        double max = arr[0];
        for (double num : arr) {
            if (num > max) max = num;
        }
        return max;
    }


}
