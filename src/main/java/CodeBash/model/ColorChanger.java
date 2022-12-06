/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson, Nahom Ayele, Nolan Sauers, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/29/22
 * Time: 8:25 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model
 * Class: ColorChanger
 *
 * Description:
 * The class that changes the color of the scenes
 * ****************************************
 */

package CodeBash.model;

import javafx.scene.Scene;

/**
 * The class that changes the color of the scenes
 * depending on the enum of ColorState
 */
public class ColorChanger {

    /** The css files for all the modes */
    private String darkModeUrl;
    private String lightModeUrl;
    private String purpleModeUrl;

    /**
     * Initializes the themes of the scenes
     */
    public ColorChanger() {
        //this.colorState = colorState;

        this.darkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
        this.lightModeUrl = getClass().getResource("/CodeBash/CodeBashLight.css").toExternalForm();
        this.purpleModeUrl = getClass().getResource("/CodeBash/CodeBashPurple.css").toExternalForm();
    }

    /**
     * The method that changes the color displayed depending on the Enum of ColorState
     * @param colorState - the Enum that determines the scenes' theme colors
     * @param welcomeScene - the welcome scene
     * @param gamePlayScene - the game play scene
     * @param resultsScene - the results scene
     */
    public void changeColorDisplay(ColorState colorState, Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {

        // Removes all the color modes from the scenes
        welcomeScene.getStylesheets().remove(lightModeUrl);
        welcomeScene.getStylesheets().remove(purpleModeUrl);
        welcomeScene.getStylesheets().remove(darkModeUrl);

        gamePlayScene.getStylesheets().remove(purpleModeUrl);
        gamePlayScene.getStylesheets().remove(darkModeUrl);
        gamePlayScene.getStylesheets().remove(lightModeUrl);

        resultsScene.getStylesheets().remove(darkModeUrl);
        resultsScene.getStylesheets().remove(purpleModeUrl);
        resultsScene.getStylesheets().remove(lightModeUrl);

        if (colorState == ColorState.LIGHT_MODE) {

            // Adjust the welcome screen to light mode
            welcomeScene.getStylesheets().add(lightModeUrl);

            // Adjust the game play screen to light mode
            gamePlayScene.getStylesheets().add(lightModeUrl);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().add(lightModeUrl);

        }
        else if (colorState == ColorState.DARK_MODE){

            // Adjust the welcome screen to dark mode
            welcomeScene.getStylesheets().add(darkModeUrl);

            // Adjust the game play screen to dark mode
            gamePlayScene.getStylesheets().add(darkModeUrl);

            // Adjust the results screen to dark mode
            resultsScene.getStylesheets().add(darkModeUrl);
        }

        else if (colorState == ColorState.PURPLE_MODE) {

            // Adjust the results screen to purple mode
            welcomeScene.getStylesheets().add(purpleModeUrl);

            // Adjust the results screen to purple mode
            gamePlayScene.getStylesheets().add(purpleModeUrl);

            // Adjust the results screen to purple mode
            resultsScene.getStylesheets().add(purpleModeUrl);
        }
    }
}
