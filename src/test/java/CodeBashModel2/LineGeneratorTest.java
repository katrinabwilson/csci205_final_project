package CodeBashModel2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LineGeneratorTest {

    /** A LineGenerator object to use for testing */
    private LineGenerator lineGenerator;

    @BeforeEach
    void setUp() {
        lineGenerator = new LineGenerator();
    }

    @Test
    void scanDocuments() throws IOException {
        // Test to make sure some sentences are added
        lineGenerator.scanDocuments();
        assertTrue(lineGenerator.getSentenceList().size() > 0);
    }
}