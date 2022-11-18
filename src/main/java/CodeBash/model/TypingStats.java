/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Nolan Sauers
 * Section: 01 - 9am
 * Date: 11/16/2022
 * Time: 9:48 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model
 * Class: TypingStats
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash.model;

/**
 * Keeps track of how the user is doing in the game
 */
public class TypingStats {

    /** The number of correct keypresses */
    private int correctLetters;

    /** The number of incorrect keypresses */
    private int errors;

    /**
     * Constructs a new TypingStats object
     */
    public TypingStats() {
        correctLetters = 0;
        errors = 0;
    }

    /**
     * A simple method to track when a letter is typed correctly
     */
    public void typedCorrect() {
        correctLetters++;
    }

    /**
     * A simple method to track when a letter is typed incorrectly
     */
    public void typedIncorrect() {
        errors++;
    }

    public int getCorrectLetters() {
        return correctLetters;
    }

    public int getErrors() {
        return errors;
    }
}
