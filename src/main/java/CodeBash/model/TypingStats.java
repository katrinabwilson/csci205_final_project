/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Nolan Sauers, Nahom Ayele, Katrina Wilson, Harmony Yeung
 * Section: 01 - 9am
 * Date: 11/16/2022
 * Time: 9:48 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model
 * Class: TypingStats
 *
 * Description:
 * The class that keeps track of the user's input
 * ****************************************
 */

package CodeBash.model;

/**
 * Keeps track of how the user is doing in the game
 */
public class TypingStats {

    /** The number of correct key presses */
    private int correctLetters;

    /** The number of incorrect key presses */
    private int errors;

    /** The total number of times the player typed */
    private int totalLetters;

    /** Keeps track of the number of spaces pressed, and therefore words */
    private int numWords;

    /**
     * Constructs a new TypingStats object
     */
    public TypingStats() {
        correctLetters = 0;
        errors = 0;
        totalLetters = 0;
        numWords = 0;
    }

    /**
     * A simple method to track when a letter is typed correctly
     */
    public void typedCorrect() {
        correctLetters++;
        totalLetters++;
    }

    /**
     * A simple method to track when a letter is typed incorrectly
     */
    public void typedIncorrect() {
        errors++;
        totalLetters++;
    }

    /**
     * Helps the class keep track of the number of spaces/enters pressed
     */
    public void wordCompleted() {
        numWords++;
    }

    /**
     * Calculates the user's words per minute based on the amount of time they played
     *
     * @param time the amount of time in seconds someone played
     * @return the words per minute typed
     */
    public double getWPM(double time) {
        return numWords / (time / 60);
    }

    /**
     * Simply calculates the user's overall accuracy (should round to 2 decimal points)
     *
     * @return the player's accuracy per letter
     */
    public double calculateAccuracy() {
        if (totalLetters > 0) {
            return (double) correctLetters / totalLetters * 100;
        }
        else {
            return (double) correctLetters * 100;
        }
    }

    /**
     * Resets all the stats to their default values at the beginning of a game
     */
    public void reset() {
        correctLetters = 0;
        errors = 0;
        totalLetters = 0;
        numWords = 0;
    }

    /**
     * The getter of TypingStats
     */
    public int getErrors() {
        return errors;
    }
}
