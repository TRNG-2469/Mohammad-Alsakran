package Week1.Thursday.exceptions;
import java.util.Scanner;

public class DemoExc01 {
    public static void main(String[] args) {
        String name;
        int age=0;

        Scanner Input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = Input.nextLine();

        try {
            System.out.println("Please enter your age: ");
            age = Integer.parseInt(Input.nextLine());


        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid age entered. Please enter a valid number.");
        }finally {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            Input.close();
        }
    }
}
