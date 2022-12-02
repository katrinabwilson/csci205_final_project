/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/7/22
 * Time: 9:22 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: FXTimer
 *
 * Description:
 *
 * *****************************************/
package CodeBash.model.FXTime;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXTimer extends Application {

    // private class constant and some variables
    private static final Integer STARTTIME = 15;
    private static final Integer STARTTIME1 = 30;
    private static final Integer STARTTIME2 = 45;
    private Timeline timeline;
    private Timeline timeline1;
    private Timeline timeline2;


    private HBox hbox;
    private Label timerLabel = new Label();
    private Label timerLabel1 = new Label();
    private Integer timeSeconds = STARTTIME;
    private Integer timeSeconds1 = STARTTIME1;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Set up the Stage and the Scene (the scene graph)
        primaryStage.setTitle("FX Timer");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        // Configure the Label
        timerLabel.setText(timeSeconds.toString());
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setStyle("-fx-font-size: 3em;");

        // Create and configure the Button
        Button button = new Button();
        button.setText("Start");
        button.setOnAction(new EventHandler() {


            @Override
            public void handle(Event event) {
                if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds = STARTTIME;

                // update timerLabel
                timerLabel.setText(timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        timeSeconds--;
                                        // update timerLabel
                                        timerLabel.setText(
                                                timeSeconds.toString());
                                        if (timeSeconds <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline.playFromStart();
            }
        });
        timerLabel1.setText(timeSeconds.toString());
        timerLabel1.setTextFill(Color.BLACK);
        timerLabel1.setStyle("-fx-font-size: 3em;");


        Button button1 = new Button();
        button1.setText("Start2");
        button1.setOnAction(new EventHandler() {



            @Override
            public void handle(Event event) {
                if (timeline1 != null) {
                    timeline1.stop();
                }
                timeSeconds1 = STARTTIME1;

                // update timerLabel
                timerLabel1.setText(timeSeconds.toString());
                timeline1 = new Timeline();
                timeline1.setCycleCount(Timeline.INDEFINITE);
                timeline1.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler<ActionEvent>() {
                                    // KeyFrame event handler
                                    public void handle(ActionEvent event) {
                                        timeSeconds1--;
                                        // update timerLabel
                                        timerLabel1.setText(
                                                timeSeconds1.toString());
                                        if (timeSeconds1 <= 0) {
                                            timeline.stop();
                                        }
                                    }
                                }));
                timeline1.playFromStart();
            }
        });

        // Create and configure VBox
        // gap between components is 20
        VBox vb = new VBox(100);
        // center the components within VBox
        vb.setAlignment(Pos.BOTTOM_CENTER);
        // Make it as wide as the application frame (scene)
        vb.setPrefWidth(scene.getWidth());
        // Move the VBox down a bit
        vb.setLayoutY(30);
        // Add the button and timerLabel to the VBox
        vb.getChildren().addAll(button, timerLabel);
        vb.setAlignment(Pos.BOTTOM_RIGHT);
        vb.getChildren().addAll(button1, timerLabel1);
        // Add the VBox to the root component
        root.getChildren().add(vb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}