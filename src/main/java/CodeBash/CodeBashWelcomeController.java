/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 12/1/22
 * Time: 10:32 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashWelcomeController
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.ColorState;
import CodeBash.model.FXTime.FXModel;
import CodeBash.model.GameState;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class CodeBashWelcomeController {

    /** The Model used for this round */
    private CodeBashModel theModel;

    /** The view representation of the Welcome interface */
    private CodeBashWelcomeView welcomeView;

    /** A Timeline object that is handled frame by frame (helpful for showing decrease on screen)*/
    private Timeline timeline;

    /** The Model to get the timing information */
    private FXModel timeModel;

    private CodeBashView theView;


    /**
     * Constructs a controller that connects the model and the view for our
     * CodeBash game
     *
     * @param welcomeView - the current CodeBashWelcomeView
     * @param theModel - the current CodeBashModel
     */
    public CodeBashWelcomeController(CodeBashWelcomeView welcomeView, CodeBashModel theModel) {
        this.welcomeView = welcomeView;
        this.theModel = theModel;

        initEventHandlers();

    }

    public void setTheView(CodeBashView theView) {
        this.theView = theView;
    }

    /**
     * Handles when settings are pressed
     */
    private void initEventHandlers() {

        welcomeView.getDarkMode().setOnAction(event -> {
            welcomeView.setCurrentColorMode(ColorState.DARK_MODE);
            welcomeView.getColorChanger().changeColorDisplay(welcomeView.getCurrentColorMode(), welcomeView.getWelcomeScene(), welcomeView.getGamePlayScene(), welcomeView.getResultScene());
            welcomeView.getDarkMode().setSelected(true);
            theModel.setCurrentColorState(ColorState.DARK_MODE);

        });

        welcomeView.getLightMode().setOnAction(event -> {
            welcomeView.setCurrentColorMode(ColorState.LIGHT_MODE);
            welcomeView.getColorChanger().changeColorDisplay(welcomeView.getCurrentColorMode(), welcomeView.getWelcomeScene(), welcomeView.getGamePlayScene(), welcomeView.getResultScene());
            welcomeView.getLightMode().setSelected(true);
            theModel.setCurrentColorState(ColorState.LIGHT_MODE);

        });

        welcomeView.getPurpleMode().setOnAction(event -> {
            welcomeView.setCurrentColorMode(ColorState.PURPLE_MODE);
            welcomeView.getColorChanger().changeColorDisplay(welcomeView.getCurrentColorMode(), welcomeView.getWelcomeScene(), welcomeView.getGamePlayScene(), welcomeView.getResultScene());
            welcomeView.getPurpleMode().setSelected(true);
            theModel.setCurrentColorState(ColorState.PURPLE_MODE);

        });

        welcomeView.getTime15().setOnAction(event -> {
            // keep that button selected
            welcomeView.getTime15().setSelected(true);

            if (timeline != null) {
                timeline.stop();
            };
            timeModel.timeSeconds = timeModel.STARTTIME;

            // update timerLabel
            theView.setTimerLabel("15");
            theView.getRoot().getChildren().add(theView.getTimerLabel());//.setText(timeModel.timeSeconds.toString());

            /*timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                // KeyFrame event handler
                                public void handle(ActionEvent event) {
                                    timeModel.timeSeconds--;
                                    // update timerLabel
                                    theView.timerLabel.setText(
                                            timeModel.timeSeconds.toString());
                                    theView.getShowTimer().getChildren().add(theView.getTimerLabel());

                                    welcomeView.getRoot().getChildren().addAll(theView.getTimerLabel());

                                    if (timeModel.timeSeconds <= 0) {
                                        timeline.stop();
                                    }
                                }
                            }));*/
        });
        // When the timer button is clicked, set the timer
        /*welcomeView.getTime15().setOnAction(new EventHandler() {
            welcomeView.getTime15().setSelected(true);
            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }

                timeModel.timeSeconds = timeModel.STARTTIME;

                // update timerLabel
                theView.timerLabel.setText(timeModel.timeSeconds.toString());

                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        timeModel.timeSeconds--;
                                        // update timerLabel
                                        theView.timerLabel.setText(
                                                timeModel.timeSeconds.toString());
                                        theView.getShowTimer().getChildren().add(theView.getTimerLabel());

                                        welcomeView.getWelcomeView().getRoot().getChildren().addAll(theView.getTimerLabel());


                                        if (timeModel.timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });



        });*/

        welcomeView.getTime30().setOnAction(event -> welcomeView.getTime30().setSelected(true));
        welcomeView.getTime45().setOnAction(event -> welcomeView.getTime45().setSelected(true));
        welcomeView.getTime60().setOnAction(event -> welcomeView.getTime60().setSelected(true));

        welcomeView.getEnglish().setOnAction(event -> welcomeView.getEnglish().setSelected(true));
        welcomeView.getJava().setOnAction(event -> welcomeView.getJava().setSelected(true));
        welcomeView.getPython().setOnAction(event -> welcomeView.getPython().setSelected(true));

    }



}
