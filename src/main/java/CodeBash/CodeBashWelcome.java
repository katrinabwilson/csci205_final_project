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

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.awt.*;

public class CodeBashWelcome {

    /** Used to display the start button and title */
    private VBox vBox;

    /** Root node for the scene graph */
    private BorderPane root;

    /** A toggle button for light or dark mode */
    private ToggleButton toggle;

    /** Used to display our toggle button*/
    private HBox topPane;

    private HBox bottomPane;

    private HBox colorSettings;

    /** The button that starts game play */
    private Button startBtn;

    /** Represents the title of our game */
    private Label title;

    /** If the game is in light mode */
    private SimpleBooleanProperty inLightMode;

    /** The buttons for the timer */
    private Button time15;

    private Button time30;

    private Button time45;

    private Button time60;

    private Button darkMode;

    private Button lightMode;

    private Button purpleMode;

    /** Button label */
    private Label btnLabel;


    /** This constructs our welcome Screen */
    public CodeBashWelcome(){
        initSceneGraph();
        initStyling();
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
        bottomPane = new HBox();

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


//        Label Instructions = new Label("Choose a duration 15s ... 30s ... 45s ... 60s ...\n" +
//                "\t\t Click 'Start' to begin");
//        Instructions.setId("Title");
//        vBox.getChildren().add(Instructions);
//        vBox.setAlignment(Pos.CENTER);

        // Setting up the timer buttons
        time15 = new Button("15 Seconds");
        time30 = new Button("30 Seconds");
        time45 = new Button("45 Seconds");
        time60 = new Button("60 Seconds");

        btnLabel = new Label("Choose your timer");
        btnLabel.setId("btnLabel");

        // Set up the color settings buttons
        darkMode = new Button("dark");
        lightMode = new Button("light");
        purpleMode = new Button("purple");

        // Set up light or dark mode toggle button

        toggle = new ToggleButton();
        toggle.setId("toggleBtn");

        inLightMode = new SimpleBooleanProperty(false);

        topPane.getChildren().add(toggle);
        topPane.setAlignment(Pos.BASELINE_RIGHT);

        // Adding the buttons
        bottomPane.getChildren().add(btnLabel);
        bottomPane.getChildren().addAll(time15, time30, time45, time60);
        bottomPane.setAlignment(Pos.CENTER);

        // Organize the BorderPane
        root.setTop(topPane);
        root.setCenter(vBox);
        root.setBottom(bottomPane);


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
     * @return - the toggle button that controls light/dark mode
     */
    public ToggleButton getToggleBtn() {return toggle;}

    /**
     * @return true if the game is in light mode, false otherwise
     */
    public boolean isInLightMode() {
        return inLightMode.get();
    }

    /**
     * Assigns a css file to the button that controls light/dark mode
     * and returns a SimpleBooleanProperty describing the state of
     * the color mode
     *
     * @return - true if in light mode, false otherwise
     */
    public SimpleBooleanProperty inLightModeProperty() {
        toggle.getStylesheets().add(this.getClass().getResource("ColorModeButton.css").toExternalForm());
        return inLightMode;
    }
}

