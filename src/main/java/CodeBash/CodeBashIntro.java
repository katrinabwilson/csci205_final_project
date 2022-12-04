/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson, Nahom Ayele, Nolan Sauers, Harmony Yeung
 * Section: 9am - 01
 * Date: 12/1/22
 * Time: 6:16 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashIntro
 *
 * Description:
 * The very first scene that introduces the
 * user to CodeBash
 * ****************************************
 */

package CodeBash;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * The Introduction to CodeBash
 */
public class CodeBashIntro {

    /** Root node for the scene graph */
    private VBox root;

    /** The button to continue off the introduction scene */
    private Button tellMeMore;

    /**
     * The method that calls the other methods
     */
    public CodeBashIntro() {
        initSceneGraph();
        initStyling();
    }

    /**
     * Setting the scene for what the CodeBash introduction looks like
     */
    public void initSceneGraph() {
        root = new VBox();
        root.setId("root");

        Label desc1 = new Label("looking to improve your lightning fast typing skills?\n " +
                                "\n       forgetting syntax to certain programming language?\n" +
                                "\nlucky you! you've come to the right place.");
        desc1.setId("intro");

        root.getChildren().add(desc1);
        root.setAlignment(Pos.CENTER);

        tellMeMore = new Button("tell me more...");
        tellMeMore.setId("transitionButton");
        root.getChildren().add(tellMeMore);
    }

    /**
     * Setting the style for the introduction
     */
    public void initStyling() {
        root.setSpacing(20);
    }

    /**
     * The getters for CodeBashIntro
     */
    public Button getTellMeMore() {
        return tellMeMore;
    }

    public VBox getRoot() {
        return root;
    }
}
