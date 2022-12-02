/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 12/1/22
 * Time: 10:36 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: FXMain
 *
 * Description:
 *
 * *****************************************/
package CodeBash.model.FXTime;


import CodeBash.CodeBashController;
import CodeBash.CodeBashResults;
import CodeBash.CodeBashView;
import CodeBash.CodeBashWelcome;
import CodeBash.model.CodeBashModel;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain  extends Application {
    public FXModel theModel;
    public FXView theView;

    public FXController theController;



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Timer");
        Scene scene = new Scene(theView.getRoot());
        scene.getStylesheets().add(
                getClass().getResource("/CodeBash/Model/TimingClass/Timing.css")
                        .toExternalForm()
        );
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args);}
    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new FXModel();
        this.theView = new FXView(theModel);
        this.theController = new FXController(theModel,theView);


    }

}

