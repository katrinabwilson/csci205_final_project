/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 *
 * Name: Katrina Wilson
 * Section: 9am - 01
 * Date: 11/14/22
 * Time: 2:18 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash
 * Class: LineGeneratorTest
 *
 * Description: A basic test file that checks if
 * the class LineGenerator creates an ArrayList of
 * sentences from different books.
 *
 * ****************************************
 */

package CodeBash;

import CodeBashModel2.LineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LineGeneratorTest {

    /** A LineGenerator object to use for testing */
    private LineGenerator lineGenerator;

    @BeforeEach
    void setUp() {
        lineGenerator = new LineGenerator();
    }

    /** Check that a lineGenerator scans documents and creates a sentence list with content*/
    @Test
    void scanDocuments() throws IOException {
        // Test to make sure some sentences are added
        lineGenerator.scanDocuments();
        assertTrue(lineGenerator.getSentenceList().size() > 0);
    }
}
