/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/15/22
 * Time: 8:48 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashResults
 *
 * Description:
 *
 * *****************************************/
package CodeBash;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CodeBashResults {

    /** Root node for the scene graph */
    private VBox root;

    private Label title;

    private void initStyling() {
        root.setPrefSize(800, 200);
        root.setSpacing(20);

    }

    private void initSceneGraph() {
        root = new VBox();
        title = new Label(" Good Game");
        title.setId("Title");
        // Add title text
        root.getChildren().add(title);
        root.setAlignment(Pos.CENTER);



    }
    public Parent getRoot(){return root;}



    public CodeBashResults(){
        initSceneGraph();
        initStyling();

    }
}

