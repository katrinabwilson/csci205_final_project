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

    /** Will hold the path to the dark mode css file */
    private String darkModeUrl;

    /** Will hold the path to the light mode css file */
    private String lightModeUrl;

    /** The current color mode of the game*/
    private ColorMode colorMode;

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
        stage.setTitle("CodeBash");
        Scene scene = new Scene(theView.getRoot());
        Scene welcomeScene = new Scene(theWelcome.getRoot());
        Scene resultScene = new Scene(theResults.getRoot());
        colorMode = ColorMode.DARK_MODE;

        // URLs to the css files for the welcome screen
        darkModeUrl = getClass().getResource("WelcomeDark.css").toExternalForm();
        lightModeUrl = getClass().getResource("WelcomeLight.css").toExternalForm();

        // Change the display of the game play screen
        //changeColorDisplay(scene);
        String css = this.getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Putting the information on our window
        stage.setScene(welcomeScene);
        welcomeScene.getStylesheets().add(
                getClass().getResource("/CodeBash/WelcomeDark.css").toExternalForm());

        // When you hit the start button, the game starts
        theWelcome.getStartBtn().setOnMouseClicked(event->stage.setScene(scene));

        // Create bindings for the light/dark mode toggle button
        theWelcome.inLightModeProperty().bind(theWelcome.getToggleBtn().selectedProperty());
        theWelcome.getToggleBtn().textProperty().bind(Bindings.when(theWelcome.inLightModeProperty())
                .then("DARK MODE")
                .otherwise("LIGHT MODE"));

        // In the game play interface, when "QUIT" is clicked, bring the user to a result screen
        theView.getQuitBtn().setOnMouseClicked(event -> stage.setScene(resultScene));


        // When the "PLAY AGAIN" button is hit, bring the user back to the welcome screen
        theResults.getPlayAgain().setOnMouseClicked(event -> stage.setScene(welcomeScene));

        // Start the display in dark mode
        resultScene.getStylesheets().add(darkModeUrl);

        // Change the color display of the 3 interfaces
        theWelcome.getToggleBtn().setOnMouseClicked(event->changeColorDisplay(welcomeScene, scene, resultScene,stage));

        // Displays our window
        stage.sizeToScene();
        stage.show();

        theView.getRoot().requestFocus();
    }

    /**
     * This method changes the coloring of the 3 screens the user interacts with,
     * based on the setting they choose with the toggle button.
     *
     * @param welcomeScene - the start of the game, user picks the settings and hits start
     * @param gamePlayScene - where the user plays the game
     * @param resultsScene - where the user's stats are displayed
     */
    public void changeColorDisplay(Scene welcomeScene, Scene gamePlayScene, Scene resultsScene, Stage stage) {

        if (theWelcome.isInLightMode()) {

            // Adjust the welcome screen to light mode
            welcomeScene.getStylesheets().remove(darkModeUrl);
            welcomeScene.getStylesheets().add(lightModeUrl);
            colorMode = ColorMode.LIGHT_MODE;

            // Adjust the game play screen to light mode
            String css = this.getClass().getResource("/CodeBash/CodeBashLight.css").toExternalForm();
            gamePlayScene.getStylesheets().add(css);

            // Adjust the results screen to light mode
            //css = this.getClass().getResource("/CodeBash/WelcomeLight.css").toExternalForm();
            resultsScene.getStylesheets().remove(welcomeDarkModeUrl);
            resultsScene.getStylesheets().add(welcomeLightModeUrl);
            //stage.setScene(gamePlayScene);
        }
        else {

            // Adjust the welcome screen to dark mode
            welcomeScene.getStylesheets().remove(lightModeUrl);
            welcomeScene.getStylesheets().add(darkModeUrl);
            colorMode = ColorMode.DARK_MODE;

            // Adjust the game play screen to dark mode
            System.out.println("trying to change the game play to dark mode");
            String css = this.getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
            gamePlayScene.getStylesheets().add(css);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().remove(welcomeLightModeUrl);
            //css = this.getClass().getResource("/CodeBash/WelcomeDark.css").toExternalForm();
            resultsScene.getStylesheets().add(welcomeDarkModeUrl);


        }
    }
}

