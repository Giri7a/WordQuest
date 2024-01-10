import java.util.Scanner;
import java.util.Random;
class HangmanGame {
    private String[] words = {"java", "programming", "hangman", "computer", "algorithm", "developer"};
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int maxAttempts;
    private int remainingAttempts;

    public HangmanGame() {
        Random random = new Random();
        wordToGuess = words[random.nextInt(words.length)];
        maxAttempts = 7;
        remainingAttempts = maxAttempts;
        currentGuess = new StringBuilder(wordToGuess.length());
        for (int i = 0; i < wordToGuess.length(); i++) {
            currentGuess.append("_");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + currentGuess.toString());

        while (remainingAttempts > 0 && currentGuess.indexOf("_") != -1) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            if (wordToGuess.indexOf(guess) != -1) {
                System.out.println("Correct!");
                updateCurrentGuess(guess);
            } else {
                System.out.println("Incorrect guess. Try again!");
                remainingAttempts--;
                System.out.println("Remaining attempts: " + remainingAttempts);
            }
            System.out.println("Current guess: " + currentGuess.toString());
        }

        if (currentGuess.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private void updateCurrentGuess(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
            }
        }
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
