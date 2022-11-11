/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Nolan Sauers, Katrina Wilson, Nahom Ayele, Harmony Yeung
 * Section: 01 - 9am
 * Date: 11/4/2022
 * Time: 9:42 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBash
 *
 * Description:
 * The main class for our project.
 * ****************************************
 */

package CodeBashModel;

import java.io.IOException;
import java.util.Random;

public class CodeBash {
    /** Generates a list of possible sentences and stores them */
    private LineGenerator lineGenerator;

    /** Evaluates each letter as it's typed */
    private LetterEvaluator letterEvaluator;

    /** Instance of Random to choose a sentence randomly */
    private Random rand;

    /** Creates a new instance of the main model class */
    public CodeBash() throws IOException {
        lineGenerator = new LineGenerator();
        lineGenerator.scanDocuments();
        rand = new Random();
    }

    /**
     * Decides the next sentence to be displayed
     *
     * @return a random sentence from the list held in lineGenerator
     */
    public String getNextSentence() {
        return lineGenerator.getSentenceList().get(rand.nextInt(lineGenerator.getSentenceList().size()));
    }

}
