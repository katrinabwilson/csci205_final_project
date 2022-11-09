package CodeBashModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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