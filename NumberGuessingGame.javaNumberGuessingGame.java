import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_ATTEMPTS = 7;
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        int totalRounds = 0;
        int roundsWon = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        do {
            int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");                            

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");

                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a valid number: ");
                    scanner.next(); // discard invalid input
                }
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed it right.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was: " + numberToGuess);
            }

            totalRounds++;
            scanner.nextLine(); // consume leftover newline
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\n=== Game Over ===");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();
    }
}
