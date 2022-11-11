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

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class CodeBashController {
    private CodeBashModel2 theModel;
    private CodeBashView theView;

    /**
     * Construct a controller that connects the model and the view for our
     * temperature conversion program
     *
     * @param theModel
     * @param theView
     */
    public CodeBashController(CodeBashModel2 theModel, CodeBashView theView) {
        this.theModel = theModel;
        this.theView = theView;

        initEventHandlers();
        initBindings();
    }

    /**
     * This is an internal helper method to initialize the event handlers
     */
    private void initEventHandlers() {
        //this.theView.getRoot().setOnKeyPressed();
        //this.theView.getBtnConvert().setOnAction(this::handleActionEvent);
        //this.theView.getTextFieldTempInput().setOnAction(this::handleActionEvent);
        //this.theView.getRbFtoC().setOnAction(this::handleActionEvent);
        //this.theView.getRbCtoF().setOnAction(this::handleActionEvent);

        // A listener to respond whenever that property changes
//        theModel.lastTempConvertedInCProperty().addListener((observable, oddValue, newValue) -> {
//            double hue = (1 - newValue.doubleValue()/ 40.0) * 240;
//            if (hue > 240) hue = 240;
//            if (hue < 0 ) hue = 0;
//            String hsbString = "hsb(" + hue + ",100%,75%);";
//            this.theView.getLblResult().setStyle(
//                    "-fx-border-color: " + hsbString +
//                            "-fx-text-fill: " + hsbString
//            );
//
//        });
    }

    /**
     * Initialize the bindings used in our app
     */
    private void initBindings(){
//        theModel.isSetForFtoCProperty().bind(theView.getRbFtoC().selectedProperty());
//        theModel.isSetForCtoFProperty().bind(theView.getRbCtoF().selectedProperty());
//
//        theView.getLblUnits().textProperty().bind(Bindings.when(theModel.isSetForFtoCProperty())
//                .then("(F)")
//                .otherwise("(C)"));
//
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handleActionEvent(ActionEvent event) {
//        try {
//            String s = this.theView.().getText();
//            if (s.length() > 0) {
//                String result = this.theModel.strTempConvert(s);
//                this.theView.getLblResult().setText(result);
//            }
//        }
//        catch (NumberFormatException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Incorrect input!");
//            alert.setHeaderText("Incorrect input specified!");
//            alert.setContentText(String.format("Can not convert \"%s\"",
//                    this.theView.getTextFieldTempInput().getText()));
//            alert.show();
//        }
    }
}

