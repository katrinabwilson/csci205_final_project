/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/11/22
 * Time: 9:30AM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashView
 *
 * Description: This represents the basic GUI part of CodeBash.
 * This includes the code to display the text the user has to type
 * and other settings
 * ****************************************
 */
package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.FXTime.FXModel;
import CodeBash.model.FXTime.FXView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * The GUI of CodeBash that displays the text that the user types
 * and the settings options
 */
public class CodeBashView {

    /** The model that contains the data and logic behind this view */
    private CodeBashModel theModel;

    /** The welcomeView class */
    private CodeBashWelcome welcomeView;

    /** Used to display our logo button */
    private HBox topPane;

    /** Time label that will show passage of time */
    private Label timerLabel;

    /** Root node for the scene graph */
    private VBox root;

    /** The view of the Timer */
    private FXView viewTime;

    /** The model for the Timer */
    private FXModel model;

    /** The button that ends game and timer */
    private Button quitBtn;

    /** Displays each letter in order */
    private HBox letterDisplay;

    /** Displays the current sentence to be typed */
    private TextArea sentence;

    /** Stores each letter in the given sentence */
    private ArrayList<Text> textObjects;

    /** Where the timer is displayed */
    private HBox showTimer;


    /**
     * Initialize a new CodeBashView
     */
    public CodeBashView (CodeBashModel theModel){
        this.theModel = theModel;
        theModel.createNextSentence();

        initSceneGraph();
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        root = new VBox();
        showTimer = new HBox();
        viewTime = new FXView(model);
        topPane = new HBox();
        VBox middlePane = new VBox();

        sentence = new TextArea();
        welcomeView = new CodeBashWelcome(theModel);
        letterDisplay = new HBox();
        timerLabel = new Label("15");
        timerLabel.setId("countDown");
        showTimer.getChildren().add(timerLabel);
        showTimer.setAlignment(Pos.BOTTOM_RIGHT);


        letterDisplay.setId("letterDisplay");

        root.setId("root");

        // Place topPane in between start button and title
        createLetterTexts(theModel.getCurrentSentence());

        // Set up the button to initiate typing
        quitBtn = new Button("QUIT");
        quitBtn.setAlignment(Pos.TOP_CENTER);
        quitBtn.setId("transitionButton");

        // Add title text
        Label title = new Label(" CodeBash");
        title.setId("Title");
        topPane.getChildren().add(title);
        topPane.setAlignment(Pos.TOP_LEFT);

        Label directions = new Label("press enter to type the next line. \ntype correct letters? white text. type wrong letters? you'll see.");
        directions.setId("instructions");
        topPane.getChildren().add(directions);
        topPane.setAlignment(Pos.TOP_LEFT);

        middlePane.getChildren().addAll(showTimer, letterDisplay, quitBtn);
        middlePane.setAlignment(Pos.CENTER);
        root.getChildren().add(topPane);
        root.getChildren().add(middlePane);

    }

    /**
     * This creates Text objects that are then added to the game
     * play screen that the user types on. These letters are from
     * a randomly generated sentence.
     *
     * @param sentence - the sentence that we want the user to type
     */
    public void createLetterTexts(String sentence) {
        letterDisplay.getChildren().clear();
        textObjects = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            Text letter = new Text();
            letter.setId("letter");
            letter.setText(sentence.charAt(i) + "");
            textObjects.add(letter);

            // Add the letter to the overall letter display
            letterDisplay.getChildren().add(letter);
        }
        letterDisplay.setAlignment(Pos.CENTER);
    }

    /**
     * The getters and setter of CodeBashView
     */
    public void setTimerLabel(String text) {
        this.timerLabel.setText(text);
    }

    public VBox getRoot(){
        return root;
    }

    public Button getQuitBtn(){return quitBtn;}

    public Text getTextObjectAt(int i){
        return textObjects.get(i);
    }
}


