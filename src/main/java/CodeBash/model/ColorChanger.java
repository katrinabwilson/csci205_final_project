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

    public ColorChanger() {
        //this.colorState = colorState;

        this.darkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
        this.lightModeUrl = getClass().getResource("/CodeBash/CodeBashLight.css").toExternalForm();
    }

    public void changeColorDisplay(ColorState colorState, Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {

        if (colorState == ColorState.LIGHT_MODE) {

            // Adjust the welcome screen to light mode
            welcomeScene.getStylesheets().remove(darkModeUrl);
            welcomeScene.getStylesheets().add(lightModeUrl);

            // Adjust the game play screen to light mode
            gamePlayScene.getStylesheets().remove(darkModeUrl);
            gamePlayScene.getStylesheets().add(lightModeUrl);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().remove(darkModeUrl);
            resultsScene.getStylesheets().add(lightModeUrl);

        }
        else if (colorState == ColorState.DARK_MODE){

            // Adjust the welcome screen to dark mode
            welcomeScene.getStylesheets().remove(lightModeUrl);
            welcomeScene.getStylesheets().add(darkModeUrl);

            // Adjust the game play screen to dark mode
            gamePlayScene.getStylesheets().remove(lightModeUrl);
            gamePlayScene.getStylesheets().add(darkModeUrl);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().remove(lightModeUrl);
            resultsScene.getStylesheets().add(darkModeUrl);
        }
    }
}
