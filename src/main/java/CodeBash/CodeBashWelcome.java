/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: Section 01-9am
 * Date: 11/15/22
 * Time: 12:53 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: CodeBashWelcome
 *
 * Description:
 * The class that represents the CodeBash welcome scene
 * *****************************************/
package CodeBash;

import CodeBash.model.CodeBashModel;

public class CodeBashWelcome {

    /** The current CodeBashModel being user */
    private CodeBashModel theModel;

    /** This will create the buttons and the overall JavaFx display */
    private CodeBashWelcomeView welcomeView;

    /** Used to handle when buttons are pressed, starting game play or altering settings */
    private CodeBashWelcomeController theController;

    private CodeBashView theView;
    /**
     * This constructs our Welcome interface through a View class
     * and a Controller class
     */
    public CodeBashWelcome(CodeBashModel theModel) {
        this.theModel = theModel;
        this.welcomeView = new CodeBashWelcomeView();
        this.theController = new CodeBashWelcomeController(welcomeView, theModel);
    }

    /**
     * Initializing the view and the controller
     */
    public void setTheView(CodeBashView theView) {
        this.theView = theView;
        theController.setTheView(theView);
    }

    /**
     * @return the getter for CodeBashWelcome
     */
    public CodeBashWelcomeView getWelcomeView() {
        return welcomeView;
    }

    public CodeBashWelcomeController getTheController() {
        return theController;
    }
}