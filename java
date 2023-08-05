import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int score = 0;
        int rounds = 0;

        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number game!");
        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + (++rounds));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            while (!guessed && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    guessed = true;
                    score += (attemptsLimit - attempts + 1);
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (guess < secretNumber) {
                    System.out.println("Try again. The number is higher.");
                } else {
                    System.out.println("Try again. The number is lower.");
                }
            }

            if (!guessed) {
                System.out.println("Oops! You've reached the maximum number of attempts. The secret number was: " + secretNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("\nDo you want to play again? (Y/N): ");
            String playAgainResponse = scanner.next().toUpperCase();
            playAgain = playAgainResponse.equals("Y");
        }

        System.out.println("Thanks for playing Guess the Number!");
        scanner.close();
    }
}
