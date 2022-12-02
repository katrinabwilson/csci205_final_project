/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/29/22
 * Time: 8:25 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model
 * Class: ColorChanger
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash.model;

import javafx.scene.Scene;



public class ColorChanger {
    private String darkModeUrl;

    private String lightModeUrl;

    private String purpleModeUrl;

    public ColorChanger() {
        //this.colorState = colorState;

        this.darkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
        this.lightModeUrl = getClass().getResource("/CodeBash/CodeBashLight.css").toExternalForm();
        this.purpleModeUrl = getClass().getResource("/CodeBash/CodeBashPurple.css").toExternalForm();
    }

    public void changeColorDisplay(ColorState colorState, Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {

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

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().add(darkModeUrl);
        }

        else if (colorState == ColorState.PURPLE_MODE) {
            welcomeScene.getStylesheets().add(purpleModeUrl);

            gamePlayScene.getStylesheets().add(purpleModeUrl);

            resultsScene.getStylesheets().add(purpleModeUrl);

        }
    }
}
