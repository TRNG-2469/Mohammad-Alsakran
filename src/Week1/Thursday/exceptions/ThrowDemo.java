package Week1.Thursday.exceptions;

public class ThrowDemo {
    public static void main(String[] args) {
        try{
        checkAge(19);}
        catch (ArithmeticException e) {
            System.out.println("Exceptions occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public static void checkAge(int age) throws invalidAgeException {
        if (age < 18) {
            throw new invalidAgeException("you are too young");

        }
        else {
            System.out.println("you are eligible to werk");
        }
    }
}
