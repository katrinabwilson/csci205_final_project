/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Katrina Wilson, Harmony Yeung, Nolan Sauers
 * Section: Section 01-9am
 * Date: 11/15/22
 * Time: 8:48 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashResults
 *
 * Description: A basic class that displays how the
 * user did when playing CodeBash.
 *
 * *****************************************/
package CodeBash;

import CodeBash.model.TypingStats;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CodeBashResults {

    /** Root node for the scene graph */
    private VBox root;

    /** A message displayed to the user */
    private Label title;

    /** The number of incorrect letters typed by the user */
    private Label errors;

    /** Displays the user's speed in words per minute */
    private Label wpm;

    /** Displays the user's accuracy as a percentage */
    private Label accuracy;

    /** A button that brings the player back to the welcome screen*/
    private Button playAgain;

    /** Keeps track of the current stats in the game */
    private TypingStats stats;

    /**
     * Initialize a new CodeBashResults scene
     */
    public CodeBashResults(TypingStats stats){
        this.stats = stats;

        initSceneGraph();
        initStyling();
    }

    /**
     * This method initializes how big the original display is
     */
    private void initStyling() {
        root.setPrefSize(1000, 300);
        root.setSpacing(20);
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        root = new VBox();
        root.setId("root");

        errors = new Label("Errors: " + stats.getErrors());
        wpm = new Label(String.format("Words per minute: %d", (int) stats.getWPM(30)));
        accuracy = new Label(String.format("Accuracy: %.2f%%", stats.calculateAccuracy()));

        errors.setId("stats");
        wpm.setId("stats");
        accuracy.setId("stats");

        title = new Label("");
        title.setId("Title");

        // Add results below label but above button
        root.getChildren().add(errors);
        root.getChildren().add(wpm);
        root.getChildren().add(accuracy);

        // Add title text
        root.getChildren().add(title);

        // Set up the button to initiate typing
        playAgain = new Button("PLAY AGAIN");
        playAgain.setAlignment(Pos.TOP_CENTER);
        playAgain.setId("transitionButton");
        root.getChildren().add(playAgain);

        root.setAlignment(Pos.CENTER);
    }

    public void setStatsLabels(double time) {
        this.errors.setText("Errors: " + stats.getErrors());
        this.wpm.setText(String.format("Words per minute: %d", (int) stats.getWPM(time)));
        this.accuracy.setText(String.format("Accuracy: %.2f%%", stats.calculateAccuracy()));
    }

    /**
     * Changes the end screen text based on how well you did. This is based on both your accuracy AND words
     * per minute.
     */
    public void setEndLabel(double time) {
        double wpm = stats.getWPM(time);
        double accuracy = stats.calculateAccuracy();
        if (wpm > 80 && accuracy == 100) {
            title.setText("I don't know why you're even here...");
        }
        else if (wpm > 60 && accuracy == 100) {
            title.setText("Perfect!");
        }
        else if (wpm > 40 && accuracy == 100) {
            title.setText("Get that speed up!");
        }
        else if (accuracy == 100) {
            title.setText("Are you looking down at your keyboard?");
        }
        else if (wpm > 80 && accuracy >= 90) {
            title.setText("You Bashed it out there!");
        }
        else if (wpm > 60 && accuracy >= 90) {
            title.setText("Nice work!");
        }
        else if (wpm > 40 && accuracy >= 90) {
            title.setText("A bit slow, but you're getting there!");
        }
        else if (accuracy >= 90) {
            title.setText("You're putting me to sleep with that speed...");
        }
        else if (wpm > 80 && accuracy >= 70) {
            title.setText("Slow down there, cowboy.");
        }
        else if (wpm > 60 && accuracy >= 70) {
            title.setText("Slow down and make sure you know where the keys are.");
        }
        else if (wpm > 40 && accuracy >= 70) {
            title.setText("How old are you?");
        }
        else if (accuracy >= 70) {
            title.setText("At least you're passing...?");
        }
        else if (wpm > 80) {
            title.setText("Let me guess, your cat walked on your keyboard?");
        }
        else if (wpm > 60) {
            title.setText("Are you pressing buttons at random?");
        }
        else if (wpm > 40) {
            title.setText("You should take some time to look at your keyboard.");
        }
        else {
            title.setText("Yikes, man.");
        }
    }

    /**
     * @return - the root node of the scene
     */
    public Parent getRoot(){return root;}

    /**
     * @return - the playAgain button
     */
    public Button getPlayAgain() {
        return playAgain;
    }


}

