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
 * The model for the CodeBash app that deals
 * with system data and logic that exist independent of
 * CodeBashView. In this case, such logic includes
 * methods to analyze the correctness of key presses and
 * the generation of random lines.
 * ****************************************
 */

package CodeBash.model;

import java.io.IOException;
import java.util.Random;

public class CodeBashModel {
    /** Generates a list of possible sentences and stores them */
    private LineGenerator lineGenerator;

    /** Instance of Random to choose a sentence randomly */
    private Random rand;

    private LetterEvaluator letterEvaluator;

    private String currentSentence;

    /** Creates a new instance of the main model class */
    public CodeBashModel() throws IOException {
        lineGenerator = new LineGenerator();
        lineGenerator.scanDocuments();
        rand = new Random();
    }

    /**
     * Decides the next sentence to be displayed
     *
     * @return a random sentence from the list held in lineGenerator
     */
    public void createNextSentence() {
        currentSentence = lineGenerator.getSentenceList().get(rand.nextInt(lineGenerator.getSentenceList().size()));
        //return currentSentence;
    }

    /**
     * @return - the current sentence displayed on the interface
     */
    public String getCurrentSentence() {
        return currentSentence;
    }

    /**
     * @return - the lineGenerator object being used
     */
    public LineGenerator getLineGenerator() { return lineGenerator;}

}
