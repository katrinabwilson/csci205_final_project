/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/15/22
 * Time: 12:53 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashWelcome
 *
 * Description:
 *
 * *****************************************/
package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.ColorChanger;
import CodeBash.model.ColorState;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class CodeBashWelcome {

    /** Used to display the start button and title */
    private VBox vBox;

    /** Root node for the scene graph */
    private BorderPane root;

    /** A toggle button for light or dark mode */
    //private ToggleButton toggle;

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

    /** If the game is in light mode */
    //private SimpleBooleanProperty inLightMode;

    /** The buttons for the timer */
    private Button time15;
    private Button time30;
    private Button time45;
    private Button time60;

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

    /** an instance of ColorChanger that will alter the display's coloring */
    private ColorChanger colorChanger;

    /** The current color theme the game is in */
    private ColorState currentColorMode;

    /** The current CodeBashModel being used */
    private CodeBashModel theModel;

    /** This constructs our welcome Screen */
    public CodeBashWelcome(CodeBashModel codeBashModel){
        colorChanger = new ColorChanger();

        this.theModel = codeBashModel;
        initSceneGraph();
        initStyling();
        initEventHandlers();
    }

    /**
     * When called, this method assigns scenes to the CodeBashWelcome object,
     * later to be used in changing their color styling.
     *
     * @param welcomeScene - the first scene the user is prompted with
     * @param gamePlayScene - the scene where the user plays the game
     * @param resultsScene - where the results are posted and the user is prompted to play again
     */
    public void setScenes(Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {
        this.welcomeScene = welcomeScene;
        this.gamePlayScene = gamePlayScene;
        this.resultScene = resultsScene;
    }

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this Welcome screen
     */
    private void initStyling() {
        vBox.setPrefSize(800, 200);
        vBox.setSpacing(20);
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
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
        time15 = new Button("15 Seconds");
        time30 = new Button("30 Seconds");
        time45 = new Button("45 Seconds");
        time60 = new Button("60 Seconds");

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
        root.setTop(topPane);
        root.setCenter(vBox);
        root.setBottom(settingsPane);
    }

    /**
     * @return - the root BorderPane node
     */
    public Parent getRoot(){return root;}

    /**
     * @return - the start button for the game to start
     */
    public Button getStartBtn (){return startBtn;}

    /**
     * Handles when settings are pressed
     */
    private void initEventHandlers() {
        darkMode.setOnAction(event -> {
            currentColorMode = ColorState.DARK_MODE;
            colorChanger.changeColorDisplay(currentColorMode, welcomeScene, gamePlayScene, resultScene);
            darkMode.setSelected(true);
            theModel.setCurrentColorState(ColorState.DARK_MODE);

        });

        lightMode.setOnAction(event -> {
            currentColorMode = ColorState.LIGHT_MODE;
            colorChanger.changeColorDisplay(currentColorMode, welcomeScene, gamePlayScene, resultScene);
            lightMode.setSelected(true);
            theModel.setCurrentColorState(ColorState.LIGHT_MODE);

        });

        purpleMode.setOnAction(event -> {
            currentColorMode = ColorState.PURPLE_MODE;
            colorChanger.changeColorDisplay(currentColorMode, welcomeScene, gamePlayScene, resultScene);
            purpleMode.setSelected(true);
            theModel.setCurrentColorState(ColorState.PURPLE_MODE);

        });
    }

    public ColorState getCurrentColorMode() {
        return currentColorMode;
    }
}

