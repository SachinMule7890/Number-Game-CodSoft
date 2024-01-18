package Sample_Project3;

import java.util.Scanner;
import java.util.Random;

public class guess_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int guess;
            boolean guessed = false;

            System.out.println("\nRound " + rounds + ": Guess a number between " + lowerBound + " and " + upperBound + ".");
            
            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + " - Enter your guess: ");
                guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + i + " attempts!");
                    score += i;
                    guessed = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total Score: " + score);

        scanner.close();
    }
}

