/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 12/1/22
 * Time: 6:16 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashIntro
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CodeBashIntro {

    /** Root node for the scene graph */
    private VBox root;

    private Button tellMeMore;

    public CodeBashIntro() {
        initSceneGraph();
        initStyling();
    }

    public void initSceneGraph() {
        root = new VBox();
        root.setId("root");

        Label desc1 = new Label("looking to improve your lightning fast typing skills?\n " +
                                "\n       forgetting syntax to certain programming language?\n" +
                                "\nlucky you! you've come to the right place.");
        desc1.setId("intro");
        //Label desc2 = new Label("forgetting syntax to certain programming language?");
        //desc2.setId("btnLabel");
        //Label desc3 = new Label("lucky you! you've come to the right place.");
        //desc3.setId("btnLabel");

        root.getChildren().add(desc1);
        root.setAlignment(Pos.CENTER);

        tellMeMore = new Button("tell me more...");
        tellMeMore.setId("transitionButton");
        root.getChildren().add(tellMeMore);


    }

    public void initStyling() {
        root.setPrefSize(800, 300);
        root.setSpacing(20);
    }

    public Button getTellMeMore() {
        return tellMeMore;
    }

    public VBox getRoot() {
        return root;
    }
}
