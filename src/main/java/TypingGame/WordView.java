/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:14 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: WordView
 *
 * Description:
 *
 * ****************************************
 */

package TypingGame;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WordView extends HBox {

    private char[] letters;
    private int correctLetters = 0;
    public WordView(String word) {
        letters = word.toUpperCase().toCharArray();
        for (char c : word.toUpperCase().toCharArray()) {
            Text letter = new Text(c + "");
            letter.setFont(Font.font(108));

            getChildren().add(letter);
        }

        this.setAlignment(Pos.CENTER);
    }

    public void handleKeyPress(String letter) {
        if (isFinished())
            return;

        char c = letters[correctLetters];

        // When the user correctly guesses the letter, the letter disappears
        if (letter.charAt(0) == c) {
            getChildren().get(correctLetters).setVisible(false);
            correctLetters++;

        } else {
            // incorrectly typed - up to us to decided
        }

    }

    public boolean isFinished() {
        return correctLetters == letters.length;
    }
}
