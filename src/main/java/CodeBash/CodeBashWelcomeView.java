/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson, Nahom Ayele, Nolan Sauers, Harmony Yeung
 * Section: 9am - 01
 * Date: 12/1/22
 * Time: 10:37 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashWelcomeView
 *
 * Description:
 * The CodeBash welcome scene's view that controls how the
 * timer buttons, color buttons, the language button, and the
 * start button are displayed
 * ****************************************
 */

package CodeBash;

import CodeBash.model.ColorChanger;
import CodeBash.model.ColorState;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The CodeBash Welcome view class that displays all the buttons
 * necessary for the settings options
 */
public class CodeBashWelcomeView {

    /** Used to display the start button and title */
    private VBox vBox;

    /** Root node for the scene graph */
    private VBox root;

    /** Used to display our toggle button*/
    private HBox topPane;

    /** An HBox with the timer settings */
    private HBox timerPane;

    /** A VBox with all the settings */
    private VBox settingsPane;

    /** The button that starts game play */
    private Button startBtn;

    /** Represents the title of our game */
    private Label title;

    /** Represents the instructions for our game */
    private Label instructions;

    /** A label that changes that displays the seconds passing */
    public Label timerLabel;

    /** The buttons for the timer */
    private ToggleButton time15;
    private ToggleButton time30;
    private ToggleButton time45;
    private ToggleButton time60;

    /** The toggle group for the timers */
    private ToggleGroup timers;

    /** the dark mode button */
    private ToggleButton darkMode;

    /** the light mode button */
    private ToggleButton lightMode;

    /** the purple mode button*/
    private ToggleButton purpleMode;

    /** The toggle group for the language buttons */
    private ToggleGroup languageGroup;

    /** The english mode button */
    private ToggleButton english;

    /** The java mode button */
    private ToggleButton java;

    /** The python mode button */
    private ToggleButton python;

    /** Button label */
    private Label btnLabel;

    /** The toggle group for color*/
    private ToggleGroup colorGroup;

    /** The initial welcome screen */
    private Scene welcomeScene;

    /** The game play screen */
    private Scene gamePlayScene;

    /** The scene with the stats and offering the user to play again */
    private Scene resultScene;

    /** The current color theme the game is in */
    private ColorState currentColorMode;

    /** An instance of ColorChanger that will alter the display's coloring */
    private ColorChanger colorChanger;

    /**
     * Initializes the colorChanger and calls other methods
     */
    public CodeBashWelcomeView() {
        colorChanger = new ColorChanger();
        initSceneGraph();
        initStyling();

    }

    /**
     * Initializes and adds the title, instructions, buttons
     */
    public void initSceneGraph() {
        root = new VBox();
        vBox = new VBox();
        topPane = new HBox();
        timerPane = new HBox();
        settingsPane = new VBox();
        currentColorMode = ColorState.DARK_MODE;
        timerLabel = new Label("");

        // Add title text
        title = new Label(" CodeBash");
        title.setId("Title");
        topPane.getChildren().add(title);
        topPane.setAlignment(Pos.TOP_LEFT);

        // Adding instructions
        instructions = new Label("choose settings then, press start to bash");
        instructions.setId("instructions");
        topPane.getChildren().add(instructions);
        topPane.setAlignment(Pos.TOP_LEFT);

        // Setting up the timer buttons
        time15 = new ToggleButton("15");
        time30 = new ToggleButton("30");
        time45 = new ToggleButton("45");
        time60 = new ToggleButton("60");

        timers = new ToggleGroup();
        time15.setToggleGroup(timers);
        time30.setToggleGroup(timers);
        time45.setToggleGroup(timers);
        time60.setToggleGroup(timers);

        time15.setSelected(true);

        btnLabel = new Label("time (s)");
        btnLabel.setId("btnLabel");

        // Set up the color settings buttons
        // https://docs.oracle.com/javafx/2/ui_controls/toggle-button.htm
        colorGroup = new ToggleGroup();

        Label colorLabel = new Label("| color");
        colorLabel.setId("btnLabel");

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

        // Set up the language buttons
        languageGroup = new ToggleGroup();
        Label langLabel = new Label("| language");
        langLabel.setId("btnLabel");

        english = new ToggleButton("english");
        english.setId("setting");
        english.setToggleGroup(languageGroup);
        english.setSelected(true);

        java = new ToggleButton("java");
        java.setId("setting");
        java.setToggleGroup(languageGroup);

        python = new ToggleButton("python");
        python.setId("setting");
        python.setToggleGroup(languageGroup);

        // Adding the timer buttons
        timerPane.getChildren().add(btnLabel);
        timerPane.getChildren().addAll(time15, time30, time45, time60);
        timerPane.setAlignment(Pos.CENTER);

        // Adding the color settings
        timerPane.getChildren().add(colorLabel);
        timerPane.getChildren().addAll(darkMode, lightMode, purpleMode);
        timerPane.setAlignment(Pos.CENTER);

        // Adding the language settings
        timerPane.getChildren().add(langLabel);
        timerPane.getChildren().addAll(english, java, python);
        timerPane.setAlignment(Pos.CENTER);

        // Add the settings to the settingsPane VBox
        timerPane.setId("settingsBox");
        settingsPane.getChildren().add(timerPane);

        // Add more instructions
        Label enterLabel = new Label("when playing, press enter to type the next line");
        enterLabel.setId("instructions");
        vBox.getChildren().add(enterLabel);
        vBox.setAlignment(Pos.CENTER);

        // Set up the button to initiate typing
        startBtn = new Button("START");
        startBtn.setId("transitionButton");
        vBox.getChildren().add(startBtn);
        vBox.setAlignment(Pos.CENTER);

        // Organize the BorderPane
        root.setId("root");
        root.getChildren().addAll(topPane, settingsPane, vBox);
        root.setAlignment(Pos.TOP_CENTER);
    }

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this Welcome screen
     */
    private void initStyling() {
        vBox.setSpacing(50);
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

    /**
     * @return - the VBox root for CodeBashWelcomeView
     */
    public VBox getRoot() {
        return root;
    }

    /**
     * @return the toggle button for english
     */
    public ToggleButton getEnglish() {
        return english;
    }

    /**
     * @return the toggle button for java
     */
    public ToggleButton getJava() {
        return java;
    }

    /**
     * @return the toggle button for python
     */
    public ToggleButton getPython() {
        return python;
    }

    /**
     * @return the button for the Start button
     */
    public Button getStartBtn() {
        return startBtn;
    }

    /**
     * @return the toggle button for 15 seconds
     */
    public ToggleButton getTime15() {
        return time15;
    }

    /**
     * @return the toggle button for 30 seconds
     */
    public ToggleButton getTime30() {
        return time30;
    }

    /**
     * @return the toggle button for 45 seconds
     */
    public ToggleButton getTime45() {
        return time45;
    }

    /**
     * @return the toggle button for 60 seconds
     */
    public ToggleButton getTime60() {
        return time60;
    }

    /**
     * @return the toggle button for dark mode
     */
    public ToggleButton getDarkMode() {
        return darkMode;
    }

    /**
     * @return the toggle button for light mode
     */
    public ToggleButton getLightMode() {
        return lightMode;
    }

    /**
     * @return the toggle button for purple mode
     */
    public ToggleButton getPurpleMode() {
        return purpleMode;
    }

    /**
     * @return the welcome scene
     */
    public Scene getWelcomeScene() {
        return welcomeScene;
    }

    /**
     * @return the game play scene
     */
    public Scene getGamePlayScene() {
        return gamePlayScene;
    }

    /**
     * @return the results scene
     */
    public Scene getResultScene() {
        return resultScene;
    }

    /**
     * @return the current color mode
     */
    public ColorState getCurrentColorMode() {
        return currentColorMode;
    }

    /**
     * Sets the color mode for the app
     * @param currentColorMode - what you change the color mode to
     */
    public void setCurrentColorMode(ColorState currentColorMode) {
        this.currentColorMode = currentColorMode;
    }

    /**
     * @return the current color changer object
     */
    public ColorChanger getColorChanger() {
        return colorChanger;
    }
}
