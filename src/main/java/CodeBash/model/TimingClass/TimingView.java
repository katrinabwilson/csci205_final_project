/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 * Name: Harmony Yeung
 * Section: 9am - 9:50am
 * Date: 11/13/2022
 * Time: 3:01 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model.TimingClass
 * Class: TimingView
 *
 * Description:
 *
 * ****************************************
 */
package CodeBash.model.TimingClass;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TimingView {

    JFrame window;

    private FlowPane flowPane;

    public Label lblResult;

    TimingModel theModel;

    private Button time15;

    private Button time30;

    private Button time45;

    private Button time60;

    private BorderPane root;

    private VBox vbox;

    public TimingView(TimingModel theModel) {
    this.theModel = theModel;
    this.window = new JFrame();
    initSceneGraph();
    initStyling();
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getTime15() {
        return time15;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public Button getTime30() {
        return time30;
    }

    public Button getTime45() {
        return time45;
    }

    public Button getTime60() {
        return time60;
    }

    private void initSceneGraph() {
        this.root = new BorderPane();

//        ToggleGroup group = new ToggleGroup();
        time15 = new Button("15 Seconds");
        time30 = new Button("30 Seconds");
        time45 = new Button("45 Seconds");
        time60 = new Button("60 Seconds");

//        time15.se(group);
//        time30.setToggleGroup(group);
//        time45.setToggleGroup(group);
//        time60.setToggleGroup(group);

        vbox = new VBox();
//        vbox.getChildren().addAll(time15, time30, time45, time60);

        flowPane = new FlowPane();
        flowPane.setId("flowPane");

        Label label = new Label("Choose your timer");
        label.setId("label");

        lblResult = new Label("");
        lblResult.setId("lblResult");

        flowPane.getChildren().add(label);
        flowPane.getChildren().addAll(time15, time30, time45, time60);
        flowPane.getChildren().add(lblResult);

        root.setTop(flowPane);
        root.setCenter(vbox);
        root.setCenter(lblResult);
    }

    private void initStyling() {
//        // For now here but I wanna use CSS files
//        window.setSize(800, 600);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setLayout(null);
//
//        counterLabel = new JLabel("");
//        counterLabel.setBounds(300, 230, 200, 100);
//        counterLabel.setHorizontalAlignment(JLabel.CENTER);
//        counterLabel.setFont(font1);
//
//        window.add(counterLabel);
////        window.setVisible(true);

    }
}