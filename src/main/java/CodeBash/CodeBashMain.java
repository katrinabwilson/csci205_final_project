/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/12/22
 * Time: 6:30PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashMain
 *
 * Description:
 * A class file to present a GUI to analyze key presses and their accuracy
 * against the printed sentence on the interface. It
 *
 * ****************************************
 */

package CodeBash;

import CodeBash.model.CodeBashModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CodeBashMain extends Application {

    /** The model that contains the data and logic behind this app */
    private CodeBashModel theModel;

    /** The view that contains the visual representation of the data behind this app */
    private CodeBashView theView;

    /** The view that contains the visual representation of the welcome screen */
    private CodeBashWelcome theWelcome;

    /** The view that contains the visual representation of the results screen */
    private CodeBashResults theResults;

    /**
     * The controller that contains instructions for how the program deals with
     * user interaction
     */
    private CodeBashController theController;

    /**
     * Our standard main program for a JavaFX application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

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
        this.theWelcome = new CodeBashWelcome();
        this.theResults = new CodeBashResults();

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
        stage.setTitle("Code Bash");
        Scene scene = new Scene(theView.getRoot());
        Scene welcomeScene = new Scene(theWelcome.getRoot());
        Scene resultScene = new Scene(theResults.getRoot());

        String css = this.getClass().getResource("/CodeBash/CodeBash.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Putting the information on our window
        stage.setScene(welcomeScene);
        welcomeScene.getStylesheets().add(
                getClass().getResource("/CodeBash/Welcome.css").toExternalForm());

        theWelcome.getStartBtn().setOnMouseClicked(event->stage.setScene(scene));
        theView.getQuitBtn().setOnMouseClicked( event -> stage.setScene(resultScene));



        resultScene.getStylesheets().add(
                getClass().getResource("/CodeBash/Welcome.css").toExternalForm());


        stage.sizeToScene();
        // Displays our window
        stage.show();

        theView.getRoot().requestFocus();
//        theView.getQuitBtn().requestFocus();
    }
}

