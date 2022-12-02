/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 12/1/22
 * Time: 11:19 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: FXController
 *
 * Description:
 *
 * *****************************************/
package CodeBash.model.FXTime;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class FXController {

    /** The model that has the time*/
    private FXModel theModel;
    /** The display of objects on screen */
    private FXView theView;

    /** A Timeline object that is handled frame by frame (helpful for showing decrease on screen)*/
    private Timeline timeline;

    public FXController(FXModel theModel, FXView theView){
        this.theView = theView;
        this.theModel = theModel;
        initEventHandlers();
    }

    private void initEventHandlers() {
        theView.getTime15().setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }

                theModel.timeSeconds = 15;

                // update timerLabel
                theView.timerLabel.setText(theModel.timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        theModel.timeSeconds--;
                                        // update timerLabel
                                        theView.timerLabel.setText(
                                                theModel.timeSeconds.toString());

                                        theView.getVb().getChildren().addAll(theView.getTimerLabel(),theView.getTime15());

                                        theView.getRoot().getChildren().add(theView.getVb());
                                        if (theModel.timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });

        theView.getTime30().setOnAction(new EventHandler() {


            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }
                theModel.setSTARTTIME(30);
                theModel.timeSeconds = theModel.STARTTIME;

                // update timerLabel
                theView.timerLabel.setText(theModel.timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        theModel.timeSeconds--;
                                        // update timerLabel
                                        theView.timerLabel.setText(
                                                theModel.timeSeconds.toString());

                                        theView.getVb().getChildren().addAll(theView.getTimerLabel(),theView.getTime30());

                                        theView.getRoot().getChildren().add(theView.getVb());
                                        if (theModel.timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });


        theView.getTime45().setOnAction(new EventHandler() {


            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }
                theModel.setSTARTTIME(45);
                theModel.timeSeconds = theModel.STARTTIME;

                // update timerLabel
                theView.timerLabel.setText(theModel.timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        theModel.timeSeconds--;
                                        // update timerLabel
                                        theView.timerLabel.setText(
                                                theModel.timeSeconds.toString());

                                        theView.getVb().getChildren().addAll(theView.getTimerLabel(),theView.getTime45());

                                        theView.getRoot().getChildren().add(theView.getVb());
                                        if (theModel.timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });


        theView.getTime60().setOnAction(new EventHandler() {


            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }
                theModel.setSTARTTIME(60);
                theModel.timeSeconds = theModel.STARTTIME;

                // update timerLabel
                theView.timerLabel.setText(theModel.timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        theModel.timeSeconds--;
                                        // update timerLabel
                                        theView.timerLabel.setText(
                                                theModel.timeSeconds.toString());

                                        theView.getVb().getChildren().addAll(theView.getTimerLabel(),theView.getTime60());

                                        theView.getRoot().getChildren().add(theView.getVb());
                                        if (theModel.timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });






    }
}

