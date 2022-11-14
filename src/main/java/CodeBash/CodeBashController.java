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
import CodeBash.model.LetterEvaluator;
import CodeBash.model.LineGenerator;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;

import javax.sound.sampled.Line;
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

    public void setLetters(String sentence) {
        letters.clear();
        char[] letterList = sentence.toCharArray();
        for (char c : letterList) {
            letters.add(c);
        }
    }

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
//        this.theView.getStartBtn().setOnMouseClicked(event -> {
//            System.out.println("button was clicked");
//        });

        /*this.theView.getStartBtn().setOnAction(event -> {
            if (letters.get(currentLetter) != ' ') {
                theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: red");
            }
            currentLetter++;
        });*/
        this.theView.getRoot().setOnKeyPressed((key) -> {
            // TODO - ask king about view button problem
            // System.out.print(key.getText());

            // If the user is done typing the sentence
            if (currentLetter == letters.size()) {
                //theView.resetTextObjects();
                currentLetter = 0;
                theModel.createNextSentence();
                setLetters(theModel.getCurrentSentence());
                theView.createLetterTexts(theModel.getCurrentSentence());
            }

            LetterEvaluator letterEvaluator;
            // Evaluate key pressed
            System.out.println("The current correct letter: " + letters.get(currentLetter));
            //System.out.println("The typed letter: " + key.getText().charAt(0));

            // If correct, change color to green
            if ((key.getCode() != KeyCode.BACK_SPACE) && (key.getCode() != KeyCode.ENTER)) {
                char correctLetter = letters.get(currentLetter);
                char typedLetter = key.getText().charAt(0);
                letterEvaluator = new LetterEvaluator(correctLetter, typedLetter);

                if (letterEvaluator.analyzeKeyPress()) {
                    System.out.println("they match!");
                    theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: green");
                }

                // Otherwise, change color to red
                else {
                    theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: red");
                }
                currentLetter++;
            }

            else if (key.getCode() == KeyCode.ENTER) {
                currentLetter = 0;
                theModel.createNextSentence();
                setLetters(theModel.getCurrentSentence());
                theView.createLetterTexts(theModel.getCurrentSentence());

            }

            // Edge case for backspace entered (set previous color and decrement 1)
            else if (key.getCode() == KeyCode.BACK_SPACE){
                System.out.println("backspace");
                currentLetter--;
                theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: black");
            }

            // Edge case for space key entered (is supposed to consume the input)
            // DOES NOT WORK (yet)
           else if (key.getCode() == KeyCode.SPACE) {

                currentLetter++;
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
}

