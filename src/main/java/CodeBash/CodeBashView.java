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

import CodeBash.CodeBashModel1.CodeBash1;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class CodeBashView {
    /** The model that contains the data and logic behind this view */
    private CodeBash1 theModel;

    /** Root node for the scene graph */
    private VBox root;

    /** The button that starts game and timer */
    private Button startBtn;

    /** topPane is the layout container for the top of the view*/
    private FlowPane topPane;

    /** Displays the current sentence to be typed */
    private Text sentence;

    public CodeBashView (CodeBash1 theModel){
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
        topPane = new FlowPane();
        sentence = new Text();

        // Add title text
        root.getChildren().add(new Label("CodeBash"));

        // Place topPane in between start button and title
        root.getChildren().add(topPane);

        topPane.getChildren().add(sentence);

        // Set up the button to initiate typing
        startBtn = new Button("Start!");
        root.getChildren().add(startBtn);






    }

    /**
     * Apply appropriate styles to all the content in the scene graph
     * for this view
     */
    public void initStyling() {
        root.setPrefSize(800, 600);
    }














}

