import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        do {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum attempts. The correct number was: " + generatedNumber);
            }
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score + " in " + rounds + " rounds.");
        scanner.close();
    }
}

