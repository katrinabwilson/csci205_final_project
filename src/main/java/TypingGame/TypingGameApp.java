/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:04 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: TypingGameApp
 *
 * Description:
 * The main functions for the full typing game
 * ****************************************
 */

package TypingGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Checks if the word is typed correctly, calculates the amount of time taken to type the words/sentences, and
 * displays the information
 */
public class TypingGameApp extends Application {

    /** The object for the class WordSelector */
    private WordSelector selector = new WordSelector();

    /** The root */
    private StackPane root = new StackPane();

    /** The start time, used to calculate typing speed */
    private long startTime = 0;

    /**
     * Sets the size of the root and shows the next word
     * @return the root
     */
    private Parent createContent() {
        root.setPrefSize(800, 600);

        showNextWord();

        return root;
    }

    /**
     * Selects a word from the selection and uses it as the parameter for WorldView
     */
    private void showNextWord() {
        // Randomly selects a word from our list/dictionary
        String word = selector.getNextWord();

        // Create a word view object with the randomly selected word as input
        WordView view = new WordView(word);

        // We put it on the stack
        root.getChildren().setAll(view);

        startTime = System.nanoTime();
    }

    /**
     * Checks if it has finished, calculates time and displays the time calculated
     * @param letter - The word to check if it is typed correctly or incorrectly
     */
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

    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception - If something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> onKeyPress(e.getCode().toString()));
        // Putting the information on our window
        stage.setScene(scene);
        // Displays our window
        stage.show();
    }

    /**
     * The main function for our TypingGame
     *
     * @param args - the argument that the main function takes in
     */
    public static void main(String[] args) {
        launch(args);
    }
}
