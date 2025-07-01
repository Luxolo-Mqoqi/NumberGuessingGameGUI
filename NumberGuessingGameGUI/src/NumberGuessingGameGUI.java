import javax.swing.*;
import java.util.Random;

public class NumberGuessingGameGUI {
    public static void main(String[] args) {
        int totalScore = 0;
        int playAgain;

        do {
            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 10;
            int numberToGuess = new Random().nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                String guessStr = JOptionPane.showInputDialog(null,
                        "Round Guess: Attempt " + (attempts + 1) + "/" + maxAttempts +
                        "\nGuess a number between " + lowerBound + " and " + upperBound + ":");

                if (guessStr == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled by user.");
                    System.exit(0);
                }

                int userGuess;

                try {
                    userGuess = Integer.parseInt(guessStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                    continue;
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                int roundScore = (maxAttempts - attempts + 1) * 10;
                totalScore += roundScore;
                JOptionPane.showMessageDialog(null,
                        "🎉 Correct! You guessed the number in " + attempts + " attempts.\nRound Score: " + roundScore + "\nTotal Score: " + totalScore);
            } else {
                JOptionPane.showMessageDialog(null,
                        "❌ Out of attempts! The correct number was: " + numberToGuess + "\nTotal Score: " + totalScore);
            }

            playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again", JOptionPane.YES_NO_OPTION);

        } while (playAgain == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "🏆 Thanks for playing!\nYour Final Total Score: " + totalScore);
    }
}