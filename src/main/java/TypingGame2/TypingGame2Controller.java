package TypingGame2;

import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ResourceBundle;

import TypingGame2.Model.TypingGame2Model;
import TypingGame2.Model.WordGenerator;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TypingGame2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox root;

    private TypingGame2Model model;

    private WordGenerator wordGenerator;

    private int correctLetters = 0;

    private long startTime = 0;

    private ArrayList<Text> textLetters;




    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'typing-game-fxml.fxml'.";
        initTextArrays();

        //System.out.println("back in initialize... a letter in letters: " + model.getLetters());
    }

    public void initTextArrays() {
        this.model = new TypingGame2Model();
        textLetters = new ArrayList<>();


        String word = model.generateRandomWord();
        System.out.println("THE WORD: " + word);
        model.setLetters(word.toUpperCase().toCharArray());

        for (char c : model.getLetters()) {
            Text letter = new Text(c + "");
            textLetters.add(letter);
            System.out.println("the letter: " + c);
            // This allows us to change the font size and type
            letter.setFont(Font.font("Serif",95));
            // We add our modified word to our tree
            root.getChildren().add(letter);
        }


        root.setAlignment(Pos.CENTER);
    }

    public void handleKeyPress(String letter) {
        // A boolean that keeps us from having an index error
        //System.out.println("The char array: " + letters.toString());
        if (isFinished())
            return;
        // List of letters of the goal word
        char c = model.getLetters()[correctLetters];

        // When the user correctly guesses the letter, the letter disappears
        if (letter.charAt(0) == c) {
            textLetters.get(correctLetters).setVisible(false);
            correctLetters++;

        } else {
            // incorrectly typed - up to us to decided
        }

    }

    public boolean isFinished() {
        return correctLetters == model.getLetters().length;
    }

    public void onKeyPress(String letter) {
        handleKeyPress(letter);
        // Checks the is finished method in our WordView class
        if (isFinished()) {
            // Calculates elapsed time
            long endTime = System.nanoTime() - startTime;

            // Prints to terminal
            System.out.printf("Your Time: %.2f sec\n", endTime / 1000000000.0);
            showNextWord();
        }
    }

    private void showNextWord() {
        // Randomly selects a word from our list/dictionary
        String word = wordGenerator.getNextWord();

        // Create a word view object with the randomly selected word as input
        //HBox hBox = new HBox(word);

        // We put it on the stack
        //root.getChildren().setAll(view);

        startTime = System.nanoTime();

    }

}
