/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 * Name: Harmony Yeung
 * Section: 9am - 9:50am
 * Date: 11/13/2022
 * Time: 3:01 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model.TimingClass
 * Class: TimingController
 *
 * Description:
 *
 * ****************************************
 */
package CodeBash.model.TimingClass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.util.Duration;

import java.io.IOException;

public class TimingController {

    private TimingView theView;

    private TimingModel theModel;

    private String timeSet = "Time selected: ";

    public TimingController(TimingView theView, TimingModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        initEventHandlers();
//        initBindings();
    }

    private void initEventHandlers() {
        this.theView.getTime15().setOnAction(this::handleActionEvent15);
        this.theView.getTime30().setOnAction(this::handleActionEvent30);
        this.theView.getTime45().setOnAction(this::handleActionEvent45);
        this.theView.getTime60().setOnAction(this::handleActionEvent60);

    }

//    private void initBindings() {
//        theModel.time15Property().bind(theView.getTime15());
//        theModel.isSetForCtoFProperty().bind(theView.getRbCtoF().selectedProperty());
//        theView.getLblUnits().textProperty().bind(Bindings.when(theModel.isSetForFtoCProperty())
//                .then("(F)")
//                .otherwise("(C)"));
//    }

    private void handleActionEvent15(ActionEvent actionEvent) {
        theModel.getCounterLabel().setText("00:15");
        theModel.second = 15;
        theModel.setSecond(theModel.second);
        theView.getLblResult().setText(timeSet + theModel.countdown());

    }
    // Create new text object and add it to the root

    private void handleActionEvent30(ActionEvent actionEvent) {
        theModel.getCounterLabel().setText("00:30");
        theModel.second = 30;
        theModel.setSecond(theModel.second);
        theView.getLblResult().setText(timeSet + theModel.countdown());
    }

    private void handleActionEvent45(ActionEvent actionEvent) {
        theModel.getCounterLabel().setText("00:45");
        theModel.second = 45;
        theModel.setSecond(theModel.second);
        theView.getLblResult().setText(timeSet + theModel.countdown());
    }

    private void handleActionEvent60(ActionEvent actionEvent) {
        theModel.getCounterLabel().setText("01:00");
        theModel.second = 0;
        theModel.minute = 1;
        theModel.setSecond(theModel.second);
        theModel.setMinute(1);
        theView.getLblResult().setText(timeSet + theModel.countdown());
    }
}