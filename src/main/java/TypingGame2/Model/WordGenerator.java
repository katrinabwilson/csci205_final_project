/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/6/22
 * Time: 8:44 PM
 *
 * Project: csci205_final_project
 * Package: TypingGame2.Model
 * Class: WordGenerator
 *
 * Description:
 *
 * ****************************************
 */

package TypingGame2.Model;

public class WordGenerator {
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
