import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess;
        int attemptsLeft;
        int attemptsTaken;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            numberToGuess = random.nextInt(100) + 1;
            attemptsLeft = 5;
            attemptsTaken = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I've generated a random number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attemptsTaken++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attemptsTaken + " attempts.");
                    score++;
                    break;
                }

                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Thanks for playing! Your final score is " + score + ".");
            }
        }

        scanner.close();
    }
}
