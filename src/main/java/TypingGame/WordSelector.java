/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:11 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: WordSelector
 *
 * Description:
 *
 * ****************************************
 */

package TypingGame;

public class WordSelector {
    //load this from a file
    private String[] words = new String[] {
         "word",
         "selector",
         "compile",
         "integrated",
         "development",
         "environment"
    };

    // Filter words that have been used
    public String getNextWord() {
        return words[(int)(Math.random() * words.length)];
    }
}
