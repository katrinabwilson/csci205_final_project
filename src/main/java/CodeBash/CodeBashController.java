/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/12/22
 * Time: 6:30PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashController
 *
 * Description: The controller for the CodeBash
 * app that ties together the model logic and view in
 * order to handle user interaction.
 *
 * ****************************************
 */
package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.ColorState;
import CodeBash.model.LetterEvaluator;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

/**
 * In our MVC design, this class represents the Controller for our
 * CodeBash app.
 */
public class CodeBashController {
    /** The model that contains the data and logic behind this controller */
    private CodeBashModel theModel;

    /** The view that contains the visual representation of the data*/
    private CodeBashView theView;

    /**
     * An integer representing the current index of the
     * character that needs to be accessed
     */
    private int currentLetter;

    /** A character array of all the letters in the randomly generated sentence */
    private ArrayList<Character> letters;

    /**
     * Construct a controller that connects the model and the view for our
     * temperature conversion program
     *
     * @param theModel - the current CodeBashModel
     * @param theView - the current CodeBashView
     */
    public CodeBashController(CodeBashModel theModel, CodeBashView theView) {
        this.theModel = theModel;
        this.theView = theView;
        letters = new ArrayList<>();
        currentLetter = 0;
        setLetters(theModel.getCurrentSentence());

        initEventHandlers();
        initBindings();
    }

    /**
     * This is an internal helper method to initialize the event handlers
     */
    private void initEventHandlers() {
        this.theView.getRoot().setOnKeyPressed((key) -> {
            // Evaluate key pressed
            LetterEvaluator letterEvaluator;

            // If correct, change color to green
            if ((key.getCode() != KeyCode.BACK_SPACE) && (key.getCode() != KeyCode.ENTER) && (key.getCode() != KeyCode.SHIFT)) {
                char correctLetter = letters.get(currentLetter);
                char typedLetter;

                // Fix window's shift key bug
                if (!key.isShiftDown()) {
                    typedLetter = key.getText().charAt(0);
                }
                else {
                    typedLetter = key.getText().toUpperCase().charAt(0);
                }
                letterEvaluator = new LetterEvaluator(correctLetter, typedLetter);

                // Add a word to the stats class every time space is pressed
                // Better implementation for this? -- we should refactor this! - Katrina
                if (key.getCode() == KeyCode.SPACE) {
                    theModel.getStats().wordCompleted();
                }

                // If the typed letter is correct
                if (letterEvaluator.analyzeKeyPress()) {
                    theView.getTextObjectAt(currentLetter);

                    // Change the coloring depending on what the current color theme is
                    if (theModel.getCurrentColorState() == ColorState.DARK_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #d1d0c5");
                    }
                    else if (theModel.getCurrentColorState() == ColorState.LIGHT_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #d1d0c5");

                    }

                    theModel.getStats().typedCorrect();
                }

                // If the typed letter is incorrect
                else {

                    if (theModel.getCurrentColorState() == ColorState.DARK_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: Orange");
                    }
                    else if (theModel.getCurrentColorState() == ColorState.LIGHT_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #107896");

                    }
                    //theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: white");
                    theModel.getStats().typedIncorrect();

                }
                currentLetter++;
            }

            // If the user presses enter, a new sentence is shown for the user to type
            else if (key.getCode() == KeyCode.ENTER) {
                currentLetter = 0;
                theModel.getStats().wordCompleted();
                theModel.createNextSentence();
                setLetters(theModel.getCurrentSentence());
                theView.createLetterTexts(theModel.getCurrentSentence());
            }

            // When backspace entered and the user wants to try again
            else if (key.getCode() == KeyCode.BACK_SPACE){
                currentLetter--;

                theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #646669");

            }
        });

    }

    /**
     * Initialize the bindings used in our app
     */
    private void initBindings(){

    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handleActionEvent(ActionEvent event) {

    }

    /**
     * This method takes a sentence, clears the ArrayList letters, and adds its
     * letters to letters
     * @param sentence - the next sentence the user is to guess
     */
    public void setLetters(String sentence) {
        letters.clear();
        char[] letterList = sentence.toCharArray();
        for (char c : letterList) {
            letters.add(c);
        }
    }
}

