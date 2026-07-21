import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {

        int targetNumber = (int) (Math.random() * 50) + 1;

        int maxAttempts = 5;
        int attemptCount = 0;
        boolean hasGuessedCorrectly = false;
        Scanner scanner = new Scanner(System.in);

        while (attemptCount<maxAttempts && hasGuessedCorrectly==false){
            attemptCount++;
            System.out.printf("Attempt [" + attemptCount + "/5] - Enter your guess: ");
            int guess = scanner.nextInt();
            if (guess>50 || guess <1){
                System.out.println("Guess must be between 1 and 50");
                attemptCount--;
                continue;
            }
            if (guess==targetNumber){
                System.out.println("Congratulations! You guessed the secret number!");
                break;
            }
            else if(guess>targetNumber){ System.out.println("Too high! Try again.");

            }
            else if (guess<targetNumber){
                System.out.println("Too low! Try again");
            }

            if (attemptCount==maxAttempts){
                System.out.println("Game Over! You've run out of attempts, The secret number was " + targetNumber);
                break;
            }
        }
        
    }
}