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
 * order to handle user interaction
 * ****************************************
 */
package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.ColorState;
import CodeBash.model.FXTime.FXModel;
import CodeBash.model.LetterEvaluator;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

/**
 * In our MVC design, this class represents the Controller for our
 * CodeBash app
 */
public class CodeBashController {

    /** The model that contains the data and logic behind this controller */
    private CodeBashModel theModel;

    /** We need the time buttons on the welcome screen */
    private CodeBashWelcome welcomeView;

    /** The Model to get the timing information */
    private FXModel timeModel;

    /** A Timeline object that is handled frame by frame (helpful for showing decrease on screen) */
    private Timeline timeline;

    /** The view that contains the visual representation of the data */
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
    public CodeBashController(CodeBashModel theModel, CodeBashView theView, FXModel timeModel, CodeBashWelcome welcomeView) {
        this.theModel = theModel;
        this.theView = theView;
        this.timeModel = timeModel;
        this.welcomeView = welcomeView;
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

            System.out.println("current letter pressed: " + key.getCode().toString());

            // If correct, change color to green
            if ((key.getCode() != KeyCode.BACK_SPACE) && (key.getCode() != KeyCode.ENTER) && (key.getCode() != KeyCode.SHIFT)) {
                char correctLetter = letters.get(currentLetter);
                char typedLetter;

                // Fix windows shift key bug
                if (!key.isShiftDown()) {
                    typedLetter = key.getText().charAt(0);
                }
                // check for each additional edge case
                else if (key.getText().charAt(0) == '/'){
                    typedLetter = '?';
                } else if (key.getText().charAt(0) == '1') {
                    typedLetter = '!';
                } else if (key.getText().charAt(0) == ',') {
                    typedLetter = '<';
                } else if (key.getText().charAt(0) == '.') {
                    typedLetter = '>';
                } else if (key.getText().charAt(0) == '9') {
                    typedLetter = '(';
                } else if (key.getText().charAt(0) == '0') {
                    typedLetter = ')';
                } else if (key.getText().charAt(0) == '=') {
                    typedLetter = '+';
                } else if (key.getText().charAt(0) == '\'') {
                    typedLetter = '\"';
                } else if (key.getText().charAt(0) == ';') {
                    typedLetter = ':';
                } else if (key.getText().charAt(0) == '[') {
                    typedLetter = '{';
                } else if (key.getText().charAt(0) == ']') {
                    typedLetter = '}';
                }
                // otherwise, capitalize letter
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
                    theModel.getStats().typedCorrect();

                    if (theModel.getCurrentColorState() == ColorState.PURPLE_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #f4f4f2");
                    }
                    else {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #d1d0c5");
                    }

                }

                // If the typed letter is incorrect
                else {

                    // Change the coloring depending on what the current color theme is
                    if (theModel.getCurrentColorState() == ColorState.DARK_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: Orange");
                    }
                    else if (theModel.getCurrentColorState() == ColorState.LIGHT_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #107896");
                    }

                    else if (theModel.getCurrentColorState() == ColorState.PURPLE_MODE) {
                        theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: #683a71");
                    }
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
                // Catch cursor at the beginning of a line
                if (currentLetter > 0) {
                    currentLetter--;
                }
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

    /**
     * Resets the entire interface for a brand-new game when "play again" is clicked
     */
    public void reset() {
        // Fix letter/sentence display
        currentLetter = 0;
        theModel.createNextSentence();
        setLetters(theModel.getCurrentSentence());
        theView.createLetterTexts(theModel.getCurrentSentence());
        initEventHandlers();

        // Fix stats
        theModel.getStats().reset();
    }
}

