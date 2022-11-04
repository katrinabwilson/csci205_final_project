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
        String word = selector.getNextWord();

        WordView view = new WordView(word);

        root.getChildren().setAll(view);

        startTime = System.nanoTime();

    }

    private void onKeyPress(String letter) {
        WordView view = (WordView) root.getChildren().get(0);
        view.handleKeyPress(letter);

        if (view.isFinished()) {
            long endTime = System.nanoTime() - startTime;

            // Prints to terminal
            System.out.printf("Your Time: %.2f sec", endTime / 1000000000.0);
            showNextWord();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> onKeyPress(e.getCode().toString()));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
