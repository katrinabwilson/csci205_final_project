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
 * screen, welcome screen, and a results screen
 * ****************************************
 */

package CodeBash;

import CodeBash.model.CodeBashModel;
import CodeBash.model.FXTime.FXModel;
import CodeBash.model.GameState;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The class that represents the GUI to recognize the key presses and
 * instantiates the game play scene, welcome scene, and the results
 * scene
 */
public class CodeBashMain extends Application {

    /** The model that contains the data and logic behind this app */
    private CodeBashModel theModel;
    /** The model that contains the data and logic behind the timer for the app */
    private FXModel timeModel;

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

    /** The initial display page that shares some motivations behind playing the game */
    private CodeBashIntro theIntro;

    /** When start is pressed, a start time is recorded */
    private long startTime;

    /** The URL to the CSS file that contains the dark mode styling */
    private String darkModeUrl;

    /** Represents the welcome screen, the first thing the user sees */
    private Scene welcomeScene;

    /** The scene the user types on */
    private Scene gameScene;

    /** The scene that displays the game play results and */
    private Scene resultScene;

    /**
     * Our standard main program for a JavaFX application
     * @param args - the argument
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The application initialization method. This method is called immediately
     * after the Application class is loaded and constructed, but before the
     * start() method is invoked
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theIntro = new CodeBashIntro();
        this.theModel = new CodeBashModel();
        this.theWelcome = new CodeBashWelcome(theModel);
        this.theView = new CodeBashView(theModel);
        theWelcome.setTheView(theView);
        this.theController = new CodeBashController(theModel, theView, timeModel, theWelcome);
        this.theResults = new CodeBashResults(theModel.getStats());

        // URL for the initial css styling
        darkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
    }

    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set
     * Applications may create other stages, if needed, but they will not be
     * primary stages
     * @throws Exception - If something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CodeBash");
        Scene introScene = new Scene(theIntro.getRoot(),1200,700);
        introScene.getStylesheets().add(darkModeUrl);
        gameScene = new Scene(theView.getRoot(),1200,700);
        welcomeScene = new Scene(theWelcome.getWelcomeView().getRoot(),1200,700);
        resultScene = new Scene(theResults.getRoot(),1200,700);
        theWelcome.getWelcomeView().setScenes(welcomeScene, gameScene, resultScene);

        // Start a new game
        theModel.setGameState(GameState.NEW_GAME);

        // Change the display of the game play screen
        gameScene.getStylesheets().add(darkModeUrl);

        // Putting the information on our window
        stage.setScene(introScene);
        welcomeScene.getStylesheets().add(darkModeUrl);

        // Change the scene based on certain button clicks
        initSceneChanges(stage, gameScene, welcomeScene, resultScene);

        // Start the display in dark mode
        resultScene.getStylesheets().add(darkModeUrl);

        // Displays our window
        stage.sizeToScene();
        stage.show();

        theView.getRoot().requestFocus();
    }

    /**
     * This method handles instances where the user clicks different buttons.
     * Specifically, these buttons handle switching the interface the user interacts
     * with, from the welcome screen, to the game play screen, to the results screen.
     *
     * @param stage - what the scenes must be set to
     * @param scene - the game scene
     * @param welcomeScene - the welcome scene
     * @param resultScene - the results scene
     */
    private void initSceneChanges(Stage stage, Scene scene, Scene welcomeScene, Scene resultScene) {
        theIntro.getTellMeMore().setOnMouseClicked(event -> {
            stage.setScene(welcomeScene);
            theModel.setGameState(GameState.NEW_GAME);
            theController.setLetters(theModel.getCurrentSentence());
        });
        // When you hit the start button, the game starts
        theWelcome.getWelcomeView().getStartBtn().setOnMouseClicked(event-> {
            stage.setScene(scene);
            theModel.setGameState(GameState.IN_PROGRESS);
            theController.reset();
            startTime = System.currentTimeMillis();

            // Start the timer at 15 seconds if nothing else is clicked
            if (theWelcome.getWelcomeView().getTime15().isSelected()){
                theWelcome.getTheController().changeCountDown(15, "15");
            }
            else if (theWelcome.getWelcomeView().getTime30().isSelected()){
                theWelcome.getTheController().changeCountDown(30, "30");
            }
            else if (theWelcome.getWelcomeView().getTime45().isSelected()){
                theWelcome.getTheController().changeCountDown(45, "45");
            }
            else if (theWelcome.getWelcomeView().getTime60().isSelected()){
                theWelcome.getTheController().changeCountDown(60, "60");
            }

        });

        // In the game play interface, when "QUIT" is clicked, bring the user to a result screen
        theView.getQuitBtn().setOnMouseClicked(event -> {
                    long endTime = System.currentTimeMillis();
                    stage.setScene(resultScene);
                    theModel.setGameState(GameState.GAME_END);
                    theResults.setStatsLabels((endTime - startTime) / 1000.0);
                    theResults.setEndLabel((endTime - startTime) / 1000.0);
                });

        theView.getRoot().setOnKeyTyped(event -> {
            if (theModel.getGameState() == GameState.GAME_END) {
                long endTime = System.currentTimeMillis();
                stage.setScene(resultScene);
                theResults.setStatsLabels((endTime - startTime) / 1000.0);
                theResults.setEndLabel((endTime - startTime) / 1000.0);
            }
        });

        // When the "PLAY AGAIN" button is hit, bring the user back to the welcome screen
        theResults.getPlayAgain().setOnMouseClicked(event -> {
            stage.setScene(welcomeScene);
            theModel.setGameState(GameState.NEW_GAME);
            theController.reset();
            theView.getRoot().requestFocus();
        });
        // When "End Game" button is clicked, it closes the current gameplay window
        theResults.getEndGame().setOnMouseClicked(event ->
                Platform.exit());
    }
}

