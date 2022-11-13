/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/10/22
 * Time: 3:30 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashController
 *
 * Description:
 *
 * *****************************************/
package CodeBash;

import CodeBash.model.CodeBashModel;
import javafx.event.ActionEvent;

public class CodeBashController {
    private CodeBashModel theModel;
    private CodeBashView theView;

    /**
     * Construct a controller that connects the model and the view for our
     * temperature conversion program
     *
     * @param theModel
     * @param theView
     */
    public CodeBashController(CodeBashModel theModel, CodeBashView theView) {
        this.theModel = theModel;
        this.theView = theView;

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


            // Evaluate key pressed
            this.theModel.getLetterEvaluator().setCorrectLetter(letters[currentLetter]);
            this.theModel.getLetterEvaluator().setTypedLetter(key.getText().charAt(0));

            // If correct, change color to green
            if (this.theModel.getLetterEvaluator().analyzeKeyPress()) {
                theView.getTextObjectAt(currentLetter).setStyle("-fx-fill: green");
                //theView.getRoot().getChildrenUnmodifiable().get(currentLetter).setStyle("-fx-fill: green");

                currentLetter++;

            }
            // Edge case for backspace entered (set previous color and decrement 1)
//            else if (){
//
//            }
//            // Otherwise, change color to red
//            else {
//
//            }
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

