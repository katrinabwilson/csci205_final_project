/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 12/1/22
 * Time: 10:37 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashWelcomeView
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash;

import CodeBash.model.ColorChanger;
import CodeBash.model.ColorState;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CodeBashWelcomeView {
    /** Used to display the start button and title */
    private VBox vBox;

    /** Root node for the scene graph */
    private BorderPane root;

    /** Used to display our toggle button*/
    private HBox topPane;

    /** An HBox with the timer settings */
    private HBox timerPane;

    /** An HBox with the color settings */
    private HBox colorSettings;

    /** A VBox with all the settings */
    private VBox settingsPane;

    /** The button that starts game play */
    private Button startBtn;

    /** Represents the title of our game */
    private Label title;

    /** The buttons for the timer */
    private ToggleButton time15;
    private ToggleButton time30;
    private ToggleButton time45;
    private ToggleButton time60;

    private ToggleGroup timers;

    /** the dark mode button */
    private ToggleButton darkMode;

    /** the light mode button */
    private ToggleButton lightMode;

    /** the purple mode button*/
    private ToggleButton purpleMode;

    /** Button label */
    private Label btnLabel;

    /** the toggle group for color*/
    private ToggleGroup colorGroup;

    /** the initial welcome screen */
    private Scene welcomeScene;

    /** the game play screen */
    private Scene gamePlayScene;

    /** the scene with the stats and offering the user to play again */
    private Scene resultScene;

    /** The current color theme the game is in */
    private ColorState currentColorMode;

    /** an instance of ColorChanger that will alter the display's coloring */
    private ColorChanger colorChanger;

    public CodeBashWelcomeView() {
        colorChanger = new ColorChanger();
        initSceneGraph();
        initStyling();

    }

    public void initSceneGraph() {
        root = new BorderPane();
        vBox = new VBox();
        topPane = new HBox();
        timerPane = new HBox();
        colorSettings = new HBox();
        settingsPane = new VBox();
        currentColorMode = ColorState.DARK_MODE;

        // Add title text
        title = new Label(" Welcome to CodeBash");
        title.setId("Title");

        vBox.getChildren().add(title);
        vBox.setAlignment(Pos.CENTER);

        // Set up the button to initiate typing
        startBtn = new Button("START");
        startBtn.setAlignment(Pos.TOP_CENTER);
        startBtn.setId("start");
        vBox.getChildren().add(startBtn);
        vBox.setAlignment(Pos.TOP_CENTER);

        // Setting up the timer buttons
        time15 = new ToggleButton("15 Seconds");
        time30 = new ToggleButton("30 Seconds");
        time45 = new ToggleButton("45 Seconds");
        time60 = new ToggleButton("60 Seconds");

        timers = new ToggleGroup();
        time15.setToggleGroup(timers);
        time30.setToggleGroup(timers);
        time45.setToggleGroup(timers);
        time60.setToggleGroup(timers);

        time15.setSelected(true);

        btnLabel = new Label("Choose your timer");
        btnLabel.setId("btnLabel");

        // Set up the color settings buttons
        // https://docs.oracle.com/javafx/2/ui_controls/toggle-button.htm
        colorGroup = new ToggleGroup();

        darkMode = new ToggleButton("dark");
        darkMode.setId("setting");
        darkMode.setToggleGroup(colorGroup);
        darkMode.setSelected(true);

        lightMode = new ToggleButton("light");
        lightMode.setId("setting");
        lightMode.setToggleGroup(colorGroup);

        purpleMode = new ToggleButton("purple");
        purpleMode.setId("setting");
        purpleMode.setToggleGroup(colorGroup);

        Label colorLabel = new Label("Choose your color mode");
        colorLabel.setId("btnLabel");

        // Adding the buttons
        timerPane.getChildren().add(btnLabel);
        timerPane.getChildren().addAll(time15, time30, time45, time60);
        timerPane.setAlignment(Pos.CENTER);

        // Adding the color settings
        colorSettings.getChildren().add(colorLabel);
        colorSettings.getChildren().addAll(darkMode, lightMode, purpleMode);
        colorSettings.setAlignment(Pos.CENTER);

        // Add the settings to the settingsPane VBox
        settingsPane.getChildren().addAll(timerPane, colorSettings);

        // Organize the BorderPane
        root.setId("root");
        root.setTop(topPane);
        root.setCenter(vBox);
        root.setBottom(settingsPane);
    }

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this Welcome screen
     */
    private void initStyling() {
        vBox.setPrefSize(800, 200);
        vBox.setSpacing(20);
    }



    public BorderPane getRoot() {
        return root;
    }



    public Button getStartBtn() {
        return startBtn;
    }

    public ToggleButton getTime15() {
        return time15;
    }

    public ToggleButton getTime30() {
        return time30;
    }

    public ToggleButton getTime45() {
        return time45;
    }

    public ToggleButton getTime60() {
        return time60;
    }


    public ToggleButton getDarkMode() {
        return darkMode;
    }

    public ToggleButton getLightMode() {
        return lightMode;
    }

    public ToggleButton getPurpleMode() {
        return purpleMode;
    }


    public Scene getWelcomeScene() {
        return welcomeScene;
    }

    public Scene getGamePlayScene() {
        return gamePlayScene;
    }

    public Scene getResultScene() {
        return resultScene;
    }

    public ColorState getCurrentColorMode() {
        return currentColorMode;
    }

    public void setCurrentColorMode(ColorState currentColorMode) {
        this.currentColorMode = currentColorMode;
    }

    public ColorChanger getColorChanger() {
        return colorChanger;
    }

    /**
     * When called, this method assigns scenes to the CodeBashWelcome object,
     * later to be used in changing their color styling.
     *
     * @param welcomeScene  - the first scene the user is prompted with
     * @param gamePlayScene - the scene where the user plays the game
     * @param resultsScene  - where the results are posted and the user is prompted to play again
     */
    public void setScenes(Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {
        this.welcomeScene = welcomeScene;
        this.gamePlayScene = gamePlayScene;
        this.resultScene = resultsScene;
    }
}
