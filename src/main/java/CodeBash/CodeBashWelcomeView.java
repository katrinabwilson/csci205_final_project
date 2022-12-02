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
import javafx.scene.control.*;
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

    /** Represents the instructions for our game */
    private Label instructions;

    /** Asks the user to choose settings */
    private Label settingsInstructions;

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

    // The language buttons
    private ToggleGroup languageGroup;
    private ToggleButton english;
    private ToggleButton java;
    private ToggleButton python;

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

        /*Label desc1 = new Label("looking to improve your lightning fast typing skills?");
        desc1.setId("btnLabel");
        Label desc2 = new Label("forgetting syntax to certain programming language?");
        desc2.setId("btnLabel");
        Label desc3 = new Label("lucky you! you've come to the right place.");
        desc3.setId("btnLabel");

        topPane.getChildren().addAll(desc1, desc2, desc3);
        topPane.setAlignment(Pos.CENTER);*/

        // Add title text
        title = new Label(" CodeBash");
        title.setId("Title");
        topPane.getChildren().add(title);
        topPane.setAlignment(Pos.TOP_LEFT);

        // Add instructions
        instructions = new Label("choose settings then, press start to bash");
        instructions.setId("instructions");
        topPane.getChildren().add(instructions);
        topPane.setAlignment(Pos.TOP_LEFT);

        // Add setting instructions
        //settingsInstructions = new Label("Choose your settings: ");
        //settingsInstructions.setId("btnLabel");
        //vBox.getChildren().add(settingsInstructions);
        //vBox.setAlignment(Pos.CENTER);

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



        // Set up the button to initiate typing
        startBtn = new Button("START");
        startBtn.setAlignment(Pos.TOP_CENTER);
        startBtn.setId("transitionButton");
        vBox.getChildren().add(startBtn);
        vBox.setAlignment(Pos.TOP_CENTER);

        // Organize the BorderPane
        root.setId("root");
        root.setTop(topPane);
        root.setCenter(settingsPane);
        root.setBottom(vBox);
    }

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this Welcome screen
     */
    private void initStyling() {
        vBox.setPrefSize(1000, 300);
        vBox.setSpacing(20);
    }



    public BorderPane getRoot() {
        return root;
    }


    public VBox getvBox() {
        return vBox;
    }

    public ToggleGroup getLanguageGroup() {
        return languageGroup;
    }

    public ToggleButton getEnglish() {
        return english;
    }

    public ToggleButton getJava() {
        return java;
    }

    public ToggleButton getPython() {
        return python;
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
