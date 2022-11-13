/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 11/10/22
 * Time: 3:30 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashMain
 *
 * Description:
 *
 * *****************************************/
package CodeBash;

import CodeBash.model.CodeBashModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class CodeBashMain extends Application {


    private CodeBashModel theModel;
    private CodeBashView theView;
    private CodeBashController theController;

    /**
     * The application initialization method. This method is called immediately
     * after the Application class is loaded and constructed, but before the
     * start() method is invoked.
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new CodeBashModel();
        this.theView = new CodeBashView(theModel);
        this.theController = new CodeBashController(theModel, theView);

    }

    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception - If something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(theView.getRoot());
//        scene.setOnKeyPressed(e -> theController.handleKeyPress(e.getCode().toString()));
        stage.setScene(scene);

        stage.sizeToScene();
        // Displays our window
        stage.show();
    }

    /**
     * Our standard main program for a JavaFX application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


}

