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
 * against the printed sentence on the interface. It instantiates a game play
 * screen, welcome screen, and a results screen.
 * ****************************************
 */

package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.GameState;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * A simple enumeration representing the kinds of color themes for our app
 */
enum ColorMode {
    DARK_MODE,
    LIGHT_MODE
}

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

    /** The current color mode of the game*/
    private ColorMode colorMode;

    /** When start is pressed, a start time is recorded */
    private long startTime;

    /** The URL to the CSS file that contains the dark mode styling */
    private String darkModeUrl;

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
        this.theWelcome = new CodeBashWelcome(theModel);
        this.theView = new CodeBashView(theModel);
        this.theController = new CodeBashController(theModel, theView);
        this.theResults = new CodeBashResults(theModel.getStats());

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
        stage.setTitle("CodeBash");
        Scene scene = new Scene(theView.getRoot());
        Scene welcomeScene = new Scene(theWelcome.getRoot());
        Scene resultScene = new Scene(theResults.getRoot());
        theWelcome.setScenes(welcomeScene, scene, resultScene);

        colorMode = ColorMode.DARK_MODE;
        theModel.setGameState(GameState.NEW_GAME);

        // URLs to the css files for the welcome screen
        darkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();

        // Change the display of the game play screen
        scene.getStylesheets().add(darkModeUrl);

        // Putting the information on our window
        stage.setScene(welcomeScene);
        welcomeScene.getStylesheets().add(darkModeUrl);

        // When you hit the start button, the game starts
        theWelcome.getStartBtn().setOnMouseClicked(event-> {
            stage.setScene(scene);
            theModel.setGameState(GameState.IN_PROGRESS);
            startTime = System.currentTimeMillis();
        });

        // In the game play interface, when "QUIT" is clicked, bring the user to a result screen
        theView.getQuitBtn().setOnMouseClicked(event -> {
                    long endTime = System.currentTimeMillis();
                    stage.setScene(resultScene);
                    theModel.setGameState(GameState.GAME_END);
                    theResults.setStatsLabels((endTime - startTime) / 1000.0);
                });


        // When the "PLAY AGAIN" button is hit, bring the user back to the welcome screen
        theResults.getPlayAgain().setOnMouseClicked(event -> {
            stage.setScene(welcomeScene);
            theModel.setGameState(GameState.NEW_GAME);
            theController.setLetters(theModel.getCurrentSentence());
        });

        // Start the display in dark mode
        resultScene.getStylesheets().add(darkModeUrl);

        // Displays our window
        stage.sizeToScene();
        stage.show();

        theView.getRoot().requestFocus();
    }
}

