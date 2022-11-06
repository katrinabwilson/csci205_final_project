/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:04 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: TypingGameApp
 *
 * Description:
 *
 * ****************************************
 */

package TypingGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TypingGameApp extends Application {

    private WordSelector selector = new WordSelector();

    private StackPane root = new StackPane();

    private long startTime = 0;
    private Parent createContent() {
        root.setPrefSize(800, 600);


        showNextWord();

        return root;
    }


    private void showNextWord() {
        // Randomly selects a word from our list/dictionary
        String word = selector.getNextWord();

        // Create a word view object with the randomly selected word as input
        WordView view = new WordView(word);

        // We put it on the stack
        root.getChildren().setAll(view);

        startTime = System.nanoTime();

    }

    private void onKeyPress(String letter) {
        WordView view = (WordView) root.getChildren().get(0);
        view.handleKeyPress(letter);
        // Checks the is finished method in our WordView class
        if (view.isFinished()) {
            // Calculates elapsed time
            long endTime = System.nanoTime() - startTime;

            // Prints to terminal
            System.out.printf("Your Time: %.2f sec\n", endTime / 1000000000.0);
            showNextWord();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> onKeyPress(e.getCode().toString()));
        // Putting the information on our window
        stage.setScene(scene);
        // Displays our window
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
