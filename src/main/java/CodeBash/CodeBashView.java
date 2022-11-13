/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/10/22
 * Time: 10:24 AM
 *
 * Project: csci205_final_project
 * Package: CodeBashView
 * Class: View
 *
 * Description:
 *
 * *****************************************/
package CodeBash;

import CodeBash.model.CodeBashModel;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class CodeBashView {
    /** The model that contains the data and logic behind this view */
    private CodeBashModel theModel;

    /** Root node for the scene graph */
    private VBox root;

    /** The button that starts game and timer */
    private Button startBtn;

    /** topPane is the layout container for the top of the view*/
    private FlowPane topPane;

    /** Displays the current sentence to be typed */
    private Text sentence;

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
        sentence = new Text();

        // Add title text
        root.getChildren().add(new Label("CodeBash"));
        root.setAlignment(Pos.CENTER);


        // Place topPane in between start button and title
        //sentence.setText(theModel.getNextSentence());
        createLetterTexts(theModel.getNextSentence());
       // sentence.setTextAlignment(TextAlignment.CENTER);
        //root.getChildren().add(sentence);
        //root.setSpacing(10);


        // Set up the button to initiate typing
        startBtn = new Button("Start!");
        startBtn.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(startBtn);
        root.getChildren().add(letterDisplay);



    }

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
    
    public void createLetterTexts(String sentence) {
        textObjects = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            Text letter = new Text();
            letter.setText(sentence.charAt(i) + "");
            textObjects.add(letter);
            letterDisplay.getChildren().add(letter);
        }
        letterDisplay.setAlignment(Pos.CENTER);

    }

    public HBox getLetterDisplay() {
        return letterDisplay;
    }
}

