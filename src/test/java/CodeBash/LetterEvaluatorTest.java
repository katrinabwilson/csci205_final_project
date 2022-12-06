/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/14/22
 * Time: 2:16 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: LetterEvaluatorTest
 *
 * Description: A basic test file that checks if
 * the class LetterEvaluator compares two characters
 * correctly.
 *
 * ****************************************
 */

package CodeBash;

import CodeBash.model.LetterEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LetterEvaluatorTest {
    /** The LetterEvaluator object used in these tests */
    private LetterEvaluator letterEvaluator;

    /** The correct letter in the sentence */
    private Character correctLetter;

    /** An incorrectly typed letter */
    private Character incorrectTypedLetter;

    /** A correctly typed letter*/
    private Character correctTypedLetter;

    @BeforeEach
    void setUp() {
        this.correctLetter = 'p';
        this.incorrectTypedLetter = 't';
        this.correctTypedLetter = 'p';

    }

    /**
     * A test that first checks incorrect keyboard input, and then
     * it checks correct keyboard input.
     */
    @Test
    void analyzeKeyPress() {
        letterEvaluator = new LetterEvaluator(correctLetter, incorrectTypedLetter);
        boolean wrongInput = letterEvaluator.analyzeKeyPress();
        assertFalse(wrongInput);

        letterEvaluator = new LetterEvaluator(correctLetter, correctTypedLetter);
        boolean correctInput = letterEvaluator.analyzeKeyPress();
        assertTrue(correctInput);
    }
}
