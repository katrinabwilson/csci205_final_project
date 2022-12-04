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
import CodeBash.model.GameMode;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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
        this.timeModel = new FXModel();

        // Set the initial countdown to 15
       // changeCountDown(15, "15");
        //handleCountDown();

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
            // keep that button selected and update the timer label
            changeCountDown(15, "15");

            //handleCountDown();
        });

        welcomeView.getTime30().setOnAction(event -> {
            // keep that button selected and update the timer label
            changeCountDown(30, "30");

            //handleCountDown();
        });

        welcomeView.getTime45().setOnAction(event -> {
            // keep that button selected
            changeCountDown(45, "45");

            //handleCountDown();
        });
        welcomeView.getTime60().setOnAction(event -> {
            // keep that button selected and update the timer label
            changeCountDown(60, "60");

            //handleCountDown();
        });

        welcomeView.getEnglish().setOnAction(event -> {
            welcomeView.getEnglish().setSelected(true);
            theModel.setMode(GameMode.ENGLISH);
        });
        welcomeView.getJava().setOnAction(event -> {
            welcomeView.getJava().setSelected(true);
            theModel.setMode(GameMode.JAVA);
        });
        welcomeView.getPython().setOnAction(event -> {
            welcomeView.getPython().setSelected(true);
            theModel.setMode(GameMode.PYTHON);
        });

    }

    private void handleCountDown() {
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            // KeyFrame event handler
                            public void handle(ActionEvent event) {
                                timeModel.timeSeconds--;
                                // update timerLabel
                                theView.setTimerLabel(timeModel.timeSeconds.toString());

                                if (timeModel.timeSeconds <= 0) {
                                    timeline.stop();
                                }
                            }

                        }));
        timeline.playFromStart();
    }

    public void changeCountDown(int time, String stringTime) {
        if (time == 15) {
            welcomeView.getTime15().setSelected(true);
        }
        else if (time == 30) {
            welcomeView.getTime30().setSelected(true);
        }
        else if (time == 45) {
            welcomeView.getTime45().setSelected(true);
        }
        else if (time == 60) {
            welcomeView.getTime60().setSelected(true);
        }

        if (timeline != null) {
            timeline.stop();
        }
        timeModel.setSTARTTIME(time);
        timeModel.timeSeconds = time;

        // update timerLabel
        theView.setTimerLabel(stringTime);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        handleCountDown();
    }
}
