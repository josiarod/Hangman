

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SimpleHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] guesses = {
                "tree", "rain", " bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream"
               };

        boolean weArePlaying = true;
        while (weArePlaying) {
            System.out.println("Welcome, let's play hangman! ");
            int randomNumber = random.nextInt(guesses.length);
            char[] randomWordToGuess = guesses[randomNumber].toCharArray();
            int ammountOfGuesses = 5;
            char[] playerGuess = new char[randomWordToGuess.length];
            //String phrase1 = phrase.replaceAll("[A-Z]", "_ ");

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;
            String string = new String(randomWordToGuess);

            while (!wordIsGuessed && tries != ammountOfGuesses) {
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d ammount of guesses left.\n", ammountOfGuesses - tries);
                System.out.println("Enter your guess: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if (input == '-') {
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("You've won! The word was arraylist. " + string +".");
                    }
                }
            }


            if (!wordIsGuessed) {
                System.out.println("Sorry, you have no more guesses left. The word was " + string+"." );
                System.out.println("Thank you for playing!");
            }

            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if (choice.equals("no")) {
                weArePlaying = false;
            }

        }

        System.out.println("Game Over!");
    }

    public static void print(char array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        boolean condition = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') {
                condition = false;
            }
        }
        return condition;
    }
}