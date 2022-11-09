/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/09/22
 * Time: 10:10am
 *
 * Project: csci205_final_project
 * Package: CodeBashModel
 * Class: LetterEvaluator
 *
 * Description: This is a class that will take the correct letter and the
 * typed letter and return a boolean indicating whether the guess was correct
 * or incorrect.
 *
 * ****************************************
 */


package CodeBashModel;

public class LetterEvaluator {

    /** The letter the user should type */
    private Character correctLetter;

    /** The letter the user typed */
    private Character typedLetter;

    /**
     * Initialize an object of LetterEvaluator with the correct letter
     * and the typed letter
     *
     * @param correctLetter - what the user should type
     * @param typedLetter - what the user did type
     */
    public LetterEvaluator(char correctLetter, char typedLetter) {
        this.correctLetter = correctLetter;
        this.typedLetter = typedLetter;
    }

    /**
     * Check if the user's input matches the letter they
     * are prompted to type.
     *
     * @return true if they are equal, false otherwise
     */
    public boolean analyzeKeyPress() {
        return (correctLetter.equals(typedLetter));
    }

    public static void main(String[] args) {
        LetterEvaluator letterEvaluator = new LetterEvaluator('c', 'f');
        if (!letterEvaluator.analyzeKeyPress()) {
            System.out.println("false! this is supposed to happen.");
        }
        else {
            System.out.println("yikes. not supposed to happen.");
        }

        letterEvaluator = new LetterEvaluator('c', 'c');
        if (letterEvaluator.analyzeKeyPress()) {
            System.out.println("true! this is supposed to happen.");
        }
        else {
            System.out.println("yikes. not supposed to happen.");
        }

    }
}
