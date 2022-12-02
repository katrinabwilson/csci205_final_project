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
 * and other settings.
 *
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

public class CodeBashView {
    /** The model that contains the data and logic behind this view */
    private CodeBashModel theModel;
    private CodeBashWelcome welcomeView;

    public Label getTimerLabel() {
        return timerLabel;
    }

    public void setTimerLabel(String text) {this.timerLabel.setText(text);}

    /** Time label that will show passage of time */
    private Label timerLabel;

    /** Root node for the scene graph */
    private VBox root;

    private FXView viewTime;
    private FXModel model;


    /** The button that ends game and timer */
    private Button quitBtn;

    /** Displays each letter in order */
    private HBox letterDisplay;

    /** Displays the current sentence to be typed */
    private TextArea sentence;

    /** Stores each letter in the given sentence */
    private ArrayList<Text> textObjects;

    /**
     * Initialize a new CodeBashView
     */
    public CodeBashView (CodeBashModel theModel){
        this.theModel = theModel;
        initSceneGraph();
        initStyling();

    }

    private HBox showTimer;
    public HBox getShowTimer(){
        return showTimer;
    }
    /**
     * Returns the root of our scene graph
     * @return
     */
    public VBox getRoot(){
        return root;
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        root = new VBox();
        showTimer = new HBox();
        viewTime = new FXView( model);

        sentence = new TextArea();
        welcomeView = new CodeBashWelcome(theModel);
        letterDisplay = new HBox();
        timerLabel = new Label("GO!");
        showTimer.getChildren().add(timerLabel);

        timerLabel.setStyle("-fx-text-fill: Orange");

        letterDisplay.setId("letterDisplay");

//        // Add title text
//        root.getChildren().add(new Label("TEST")); // was CodeBash
//        root.setAlignment(Pos.CENTER);

        root.setId("root");

        // Place topPane in between start button and title
        theModel.createNextSentence();
        createLetterTexts(theModel.getCurrentSentence());

        // Set up the button to initiate typing
        quitBtn = new Button("QUIT");
        quitBtn.setAlignment(Pos.TOP_CENTER);
        quitBtn.setId("transitionButton");

        //root.getChildren().addAll(welcomeView.getWelcomeView().getRoot().getTop());
//        root.getChildren().add(viewTime.getRoot());
        root.getChildren().add(timerLabel);
        root.getChildren().add(letterDisplay);
        root.getChildren().add(quitBtn);


    }
    public Button getQuitBtn(){return quitBtn;}

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this view
     */
    public void initStyling() {
//        root.setPrefSize(800, 300);

    }

    /** ArrayList getter method that returns our text objects */
    public Text getTextObjectAt(int i){
        return textObjects.get(i);
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


}


