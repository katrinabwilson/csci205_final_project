/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Nolan Sauers
 * Section: 01 - 9am
 * Date: 11/6/2022
 * Time: 8:23 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: LineGenerator
 *
 * Description:
 *
 * ****************************************
 */

package CodeBash.CodeBashModel1;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LineGenerator {
    /** An array of the URLs to be used for the lines */
    private String[] sources;

    /** A record of every possible sentence, common or not */
    private ArrayList<String> sentenceList;

    private int minSentenceLength;

    private int maxSentenceLength;

    /**
     * Create a new TextProcessor and assign the novels to given indexes
     */
    public LineGenerator() {
        sources = new String[3];
        // The Essays of Ralph Waldo Emerson
        sources[0] = "https://www.gutenberg.org/cache/epub/16643/pg16643.txt";
        // A Tale of Two Cities
        sources[1] = "https://www.gutenberg.org/files/98/98-0.txt";
        // The Adventures of Sherlock Holmes
        sources[2] = "https://www.gutenberg.org/files/1661/1661-0.txt";

        minSentenceLength = 30;
        maxSentenceLength = 100;

        sentenceList = new ArrayList<>();
    }

    /**
     * A simple method to take in each of the URLs stored in sources and
     * return a map of each of the non-duplicate valid sentences and their
     * frequencies
     *
     * @return a HashMap of each sentence that can be chosen
     * @throws IOException if an invalid URL is placed in the Scanner
     */
    public void scanDocuments() throws IOException {

        for (int i = 1; i < sources.length; i++) {
            URL novel = new URL(sources[i]);
            Scanner in = new Scanner(novel.openStream());
            in.useDelimiter("[?!.]");

            while (in.hasNext()) {
                String word = in.next();
                // Replace ALL non-valid characters
                word = word.replaceAll("[^A-Za-z!?().,\":;\\s-]","");
                // Check for valid sentence length
                if (word.length() >= minSentenceLength && word.length() <= maxSentenceLength) {
                    sentenceList.add(word);
                }
            }
            in.close();
        }
    }

    /**
     * Getter method for all words in the dictionary for use in verifying guesses.
     *
     * @return sentenceList.keySet(), the set of all the possible sentences
     */
    public ArrayList<String> getSentenceList(){
        return this.sentenceList;
    }

    /** Temporary test method */
    public static void main(String[] args) throws IOException {
        LineGenerator lineGenerator = new LineGenerator();
        lineGenerator.scanDocuments();
        for (String line : lineGenerator.getSentenceList()) {
            System.out.println(line + "\n");
        }
    }
}
