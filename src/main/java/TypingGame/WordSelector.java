/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele, Nolan Sauers, Katrina Wilson, Harmony Yeung
 * Section: 9am - 01
 * Date: 11/4/22
 * Time: 10:11 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: WordSelector
 *
 * Description:
 * Loads a selection of words or sentences from files
 * ****************************************
 */

package TypingGame;

/**
 * The different selections of words or sentences that are inputted through files
 */
public class WordSelector {

    /**
     * The temporary list of words that the users type
     */
    private String[] words = new String[] {
         "word",
         "selector",
         "compile",
         "integrated",
         "development",
         "environment"
    };

    /**
     * Chooses the next word the user has to type
     * @return the next word to type
     */
    public String getNextWord() {
        return words[(int)(Math.random() * words.length)];
    }
}
