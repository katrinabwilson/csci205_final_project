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
import javafx.event.ActionEvent;

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
        currentLetter = 1;
        letters = new ArrayList<>();
        //theModel.createNextSentence();
        char[] letterList = theModel.getCurrentSentence().toCharArray();
        for (char c : letterList) {
            letters.add(c);
        }
        //letters.remove(0);
        System.out.print("the letter array: [");
        for (char c : letters) {
            System.out.print(c + ", ");
        }
        System.out.println("]");

        initEventHandlers();
        initBindings();
    }

    /**
     * This is an internal helper method to initialize the event handlers
     */
    private void initEventHandlers() {
        this.theView.getRoot().setOnKeyPressed((key) -> {
            // TODO - ask king about view problem
            // System.out.print(key.getText());

            LetterEvaluator letterEvaluator;
            // Evaluate key pressed
            System.out.println("The current correct letter: " + letters.get(currentLetter));
            System.out.println("The typed letter: " + key.getText().charAt(0));

            char correctLetter = letters.get(currentLetter);
            char typedLetter = key.getText().charAt(0);

            letterEvaluator = new LetterEvaluator(correctLetter, typedLetter);
            // If correct, change color to green
            if (letterEvaluator.analyzeKeyPress()) {
                System.out.println("they match!");
                theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: green");

            }
            // Edge case for backspace entered (set previous color and decrement 1)
//            else if (){
//
//            }
//            // Otherwise, change color to red
//            else {
//
//            }
            // THIS NEEDS TO BE FIXED
            currentLetter++;

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

