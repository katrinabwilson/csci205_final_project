/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/7/22
 * Time: 9:42 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame2.Model
 * Class: TypingGame2Model
 *
 * Description:
 *
 * ****************************************
 */

package TypingGame2.Model;

public class TypingGame2Model {
    private WordGenerator wordGenerator;

    private char[] letters;

    public String generateRandomWord() {
        wordGenerator = new WordGenerator();
        String randomWord = wordGenerator.getNextWord();
        return randomWord;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }
}
