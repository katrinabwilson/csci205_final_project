package TypingGame2;

import TypingGame.TypingGameApp;
import TypingGame2.Model.TypingGame2Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TypingGame2Main extends Application {
    /**
     * The model that contains the data and logic behind this app
     */
    private TypingGame2Model theModel;

    /**
     * The controller that contains instructions for how the program deals with user interaction
     */
    private TypingGame2Controller theController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.theController = new TypingGame2Controller();
        this.theModel = new TypingGame2Model();

        // Load the FXML file. Obtain the root of the scene graph.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/TypingGame2/typing-game-fxml.fxml"));
        Parent root = loader.load();


        // Set up the stage and show it
        Scene scene = new Scene(root);

        //theController.initialize();
        scene.setOnKeyPressed(e -> theController.onKeyPress(e.getCode().toString()));
        primaryStage.setTitle("Typing Game 2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
