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

package CodeBash.model;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;


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

        minSentenceLength = 50;
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
            // Regex for a sentence; line must start with a capital and end with punctuation
            Pattern p = Pattern.compile("^[A-Z][^!?.]+[!?.]");

            while (in.hasNextLine()) {
                String line = in.nextLine();

                // Trim line to just the sentence, if applicable
                if (line.contains(".")) {
                    line = line.substring(0, line.indexOf(".") + 1);
                }
                else if (line.contains("!")) {
                    line = line.substring(0, line.indexOf("!") + 1);
                }
                else if (line.contains("?")) {
                    line = line.substring(0, line.indexOf("?") + 1);
                }

                // Replace ALL non-valid characters (like symbols)
                line = line.replaceAll("[^A-Za-z!?().,\"':;\\s-]","");

                // Discard any lines that end with an incomplete phrase
                if (line.contains("Mr.") || line.contains("Mrs.") || line.contains("St.") || line.contains("Gutenberg")) {
                    line = "";
                }

                // If the sentence has valid regex, accept it into the pool (given its length is valid)
                Matcher m = p.matcher(line);
                if (m.matches()) {
                    // Check for valid sentence length
                    if (line.length() >= minSentenceLength && line.length() <= maxSentenceLength) {
                        sentenceList.add(line);
                    }
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
