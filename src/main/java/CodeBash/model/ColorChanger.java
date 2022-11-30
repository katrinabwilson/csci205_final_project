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

import CodeBash.CodeBashWelcome;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*public final enum ColorState {
    DARK_MODE,
    LIGHT_MODE,
    PURPLE_MODE,

}*/

public class ColorChanger {

    private ColorState colorState;


    /** Will hold the path to the dark mode css file */
    private String welcomeDarkModeUrl;

    /** Will hold the path to the light mode css file */
    private String welcomeLightModeUrl;

    private String gameplayDarkModeUrl;

    private String gameplayLightModeUrl;

    public ColorChanger() {
        //this.colorState = colorState;
        this.welcomeDarkModeUrl = getClass().getResource("/CodeBash/WelcomeDark.css").toExternalForm();
        this.welcomeLightModeUrl = getClass().getResource("/CodeBash/WelcomeLight.css").toExternalForm();
        this.gameplayDarkModeUrl = getClass().getResource("/CodeBash/CodeBashDark.css").toExternalForm();
        this.gameplayLightModeUrl = getClass().getResource("/CodeBash/CodeBashLight.css").toExternalForm();
    }

    public void changeColorDisplay(ColorState colorState, Scene welcomeScene, Scene gamePlayScene, Scene resultsScene) {

        if (colorState == ColorState.LIGHT_MODE) {

            // Adjust the welcome screen to light mode
            welcomeScene.getStylesheets().remove(welcomeDarkModeUrl);
            welcomeScene.getStylesheets().add(welcomeLightModeUrl);
            //colorMode = ColorMode.LIGHT_MODE;

            // Adjust the game play screen to light mode
            gamePlayScene.getStylesheets().remove(gameplayDarkModeUrl);
            gamePlayScene.getStylesheets().add(gameplayLightModeUrl);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().remove(welcomeDarkModeUrl);
            resultsScene.getStylesheets().add(welcomeLightModeUrl);
        }
        else if (colorState == ColorState.DARK_MODE){

            // Adjust the welcome screen to dark mode
            welcomeScene.getStylesheets().remove(welcomeLightModeUrl);
            welcomeScene.getStylesheets().add(welcomeDarkModeUrl);
            //colorMode = ColorMode.DARK_MODE;

            // Adjust the game play screen to dark mode
            gamePlayScene.getStylesheets().remove(gameplayLightModeUrl);
            gamePlayScene.getStylesheets().add(gameplayDarkModeUrl);

            // Adjust the results screen to light mode
            resultsScene.getStylesheets().remove(welcomeLightModeUrl);
            resultsScene.getStylesheets().add(welcomeDarkModeUrl);
        }
    }
}
