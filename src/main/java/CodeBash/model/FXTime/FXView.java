/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 12/1/22
 * Time: 11:17 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: FXView
 *
 * Description:
 *
 * *****************************************/
package CodeBash.model.FXTime;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class FXView {
    /** Gets our data from the model */
    private FXModel theModel;
    /** Our root node*/
    private Group root;

    public Button getTime30() {
        return time30;
    }

    public Button getTime45() {
        return time45;
    }

    public Button getTime60() {
        return time60;
    }

    /** Getter method of our start btn */
    public Button getTime15() {
        return time15;
    }
    private Button time15;
    private Button time30;
    private Button time45;
    private Button time60;
    private FlowPane flowPane;
    public VBox getVb() {
        return vb;
    }

    /** Hold our information */
    private VBox vb;

    public void setVb(VBox vb) {
        this.vb = vb;
    }

    public Label timerLabel;

    public Label getTimerLabel() {
        return timerLabel;
    }

    public FXView(FXModel theModel){
        this.theModel = theModel;
        initSceneGraph();
        initStyling();
    }
    /** getter method for the root node */
    public Group getRoot() {
        return root;
    }
    private void initSceneGraph() {
        root = new Group();
        vb = new VBox();

        time15 = new Button("15 Seconds");
        time30 = new Button("30 Seconds");
        time45 = new Button("45 Seconds");
        time60 = new Button("60 Seconds");


        flowPane = new FlowPane();
//        flowPane.setId("root");

        timerLabel = new Label("Choose your timer");
        timerLabel.setId("Title");


        flowPane.getChildren().add(timerLabel);
        flowPane.getChildren().addAll( time15,time30, time45, time60);



        vb.getChildren().addAll(timerLabel,flowPane);
        vb.setAlignment(Pos.CENTER);

        // Add the VBox to the root component
        root.getChildren().add(vb);
//        root.setId("root");







    }
    public void initStyling() {
//        vb.setPrefSize(300, 250);
    }
}

