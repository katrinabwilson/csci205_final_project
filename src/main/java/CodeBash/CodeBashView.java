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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CodeBashView {
    /** The model that contains the data and logic behind this view */
    private CodeBashModel theModel;

    /** Root node for the scene graph */
    private VBox root;

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

    /**
     * Returns the root of our scene graph
     * @return
     */
    public Parent getRoot(){
        return root;
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        root = new VBox();
        sentence = new TextArea();
        letterDisplay = new HBox();
        letterDisplay.setId("letterDisplay");

        // Add title text
        root.getChildren().add(new Label("")); // was CodeBash
        root.setAlignment(Pos.CENTER);

        root.setId("root");

        // Place topPane in between start button and title
        theModel.createNextSentence();
        createLetterTexts(theModel.getCurrentSentence());

        // Set up the button to initiate typing
        quitBtn = new Button("QUIT");
        quitBtn.setAlignment(Pos.TOP_CENTER);
        quitBtn.setId("quit");

        root.getChildren().add(letterDisplay);
        root.getChildren().add(quitBtn);

    }
    public Button getQuitBtn(){return quitBtn;}

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this view
     */
    public void initStyling() {
        root.setPrefSize(800, 200);
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
    // Useful to when we choose the font we want: https://www.delftstack.com/howto/java/setfont-java/
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


