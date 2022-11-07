/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:14 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: WordView
 *
 * Description:
 * Displays the words that the user is supposed to type and also changes depending on the user's input.
 * ****************************************
 */

package TypingGame;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The class that displays the words to type and changes each letter depending on the user's input
 */
public class WordView extends HBox {

    /** The letters */
    private char[] letters;

    /** The number of collect letters */
    private int correctLetters = 0;

    /**
     * Splits the words into individual characters and controls the font and size of the text
     * @param word - the word to be split by each character
     */
    public WordView(String word) {
        // Capitalize and split our word by character -> Store this list as a global attribute
        letters = word.toUpperCase().toCharArray();

        for (char c : word.toUpperCase().toCharArray()) {
            Text letter = new Text(c + "");
            // This allows us to change the font size and type
            letter.setFont(Font.font("Serif",95));
            // We add our modified word to our tree
            getChildren().add(letter);
        }
        // Puts our word on center screen
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Handles what happens to the letters when they are typed correctly and incorrectly
     * @param letter - The word that we are checking the letters of
     */
    public void handleKeyPress(String letter) {
        // A boolean that keeps us from having an index error
        if (isFinished())
            return;
        // List of letters of the goal word
        char c = letters[correctLetters];

        // When the user correctly guesses the letter, the letter disappears
        if (letter.charAt(0) == c) {
            getChildren().get(correctLetters).setVisible(false);
            correctLetters++;

        } else {
            // incorrectly typed - up to us to decided
        }
    }

    /**
     * Checks if it is finished
     * @return boolean true if finished
     */
    public boolean isFinished() {
        return correctLetters == letters.length;
    }
}
