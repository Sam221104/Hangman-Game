package application;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
public class Main extends Application {
    private TextField tfGuess = new TextField();
    private TextField tfLettersGuessed = new TextField();
    private String[] words = {"HANGMAN", "COMPUTER", "JAVA", "PROGRAMMING", "DEVELOPMENT","RIDE","MOURNING","PERIOD","INVISIBLE","SULPHUR","SCRAPE","RESPONSIBILITY","GAME","AWFUL","CEILING","ROENTGENOGRAPHY",
    		"THANATOMANIA","ONCOGENESIS","RADIANT","TRANQUIL","SERENDIPITY","LUMINESCENT","ENIGMATIC","MELLIFLUOUS","EBULLIENT","RESPLENDENT","QUIXOTIC","PETRICHOR","EFFERVESCENT","NEBULOUS","HALCYON","LUMINOUS",
    		"INEFFABLE","SERENITY","JUBILANT","ETHEREAL","RESILIENCE","AMBROSIAL","ASGARD","MUTANTS","WAKANDA","ZEPHYR","ILLUMINATE","WHIMSICAL"};
    public String getHiddenWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
    
    private Text[] text;
    private Label guessesRemaining;
    private Label resultLabel;
    private int tries;

    private ArrayList<Shape> body;
    private ObservableList<Node> children;
    private StringBuilder guessedLetters;
    private String theWord;
    
    private void FrameBorder() {
        Line frame1 = new Line(25, 25, 200, 25);
        frame1.setStroke(Color.RED);
        frame1.setStrokeWidth(3);
        children.add(frame1);
        
        Line frame2 = new Line(25, 25, 25, 300);
        frame2.setStroke(Color.RED);
        frame2.setStrokeWidth(3);
        children.add(frame2);

        Line frame3 = new Line(300, 300, 25, 300);
        frame3.setStroke(Color.RED);
        frame3.setStrokeWidth(3);
        children.add(frame3);

        Line rope = new Line(200, 25, 200, 75);
        rope.setStroke(Color.DARKORANGE);
        rope.setStrokeWidth(3);
        children.add(rope);
    }

    private void Body() {
        body = new ArrayList<>();

        Ellipse head = new Ellipse(200, 112, 35, 35);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        head.setStrokeWidth(5);
        head.setVisible(false);
        children.add(head);
        body.add(head);

        Line tor = new Line(200, 200, 200, 150);
		tor.setStroke(Color.rgb(130,130,130));
		tor.setStrokeWidth(5);
		tor.setVisible(false);
		children.add(tor);
		body.add(tor);

		Line lftArm = new Line(150, 225, 200, 175);
		lftArm.setStroke(Color.BLACK);
		lftArm.setStrokeWidth(5);
		lftArm.setVisible(false);
		children.add(lftArm);
		body.add(lftArm);

		Line rtArm = new Line(250, 225, 200, 175);
		rtArm.setStroke(Color.BLACK);
		rtArm.setStrokeWidth(5);
		rtArm.setVisible(false);
		children.add(rtArm);
		body.add(rtArm);

		Line lftLeg = new Line(200, 200, 175, 275);
		lftLeg.setStroke(Color.BLACK);
		lftLeg.setStrokeWidth(5);
		lftLeg.setVisible(false);
		children.add(lftLeg);
		body.add(lftLeg);

		Line rtLeg = new Line(200, 200, 225, 275);
		rtLeg.setStroke(Color.BLACK);
		rtLeg.setStrokeWidth(5);
		rtLeg.setVisible(false);
		children.add(rtLeg);
		body.add(rtLeg);
    }

    private void Blanks(String word) {
        Line[] blanks = new Line[word.length()];
        int xStart = 375;
        int lineLength = 25;
        int lineSpacing = 35;
        for (int i = 0; i < blanks.length; i++) {
            int xcoord = xStart + (lineSpacing * i);
            blanks[i] = new Line(xcoord, 225, xcoord - lineLength, 225);
            blanks[i].setStroke(Color.BLACK);
            blanks[i].setStrokeWidth(2.5);
            children.add(blanks[i]);
        }
    }

    private Text[] initText(String word) {
        Text[] text = new Text[word.length()];
        int xStartw = 355;
        int lineSpacingw = 35;
        for (int i = 0; i < text.length; i++) {
            int xcoordw = xStartw + (lineSpacingw * i);
            text[i] = new Text(word.substring(i, i + 1));
            text[i].setFont(new Font(30));
            text[i].setX(xcoordw);
            text[i].setY(220);
            text[i].setVisible(false);
            children.add(text[i]);
        }
        return text;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        children = pane.getChildren();
        FrameBorder();

        Body();
        theWord = getHiddenWord().toUpperCase();
        guessedLetters = new StringBuilder();
        
        Blanks(theWord);
        text = initText(theWord);
        tries = 6;

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Enter a letter:"), 0, 0);
        gridPane.add(tfGuess, 1, 0);
        gridPane.add(new Label("Letters Guessed:"), 0, 1);
        gridPane.add(tfLettersGuessed, 1, 1);
        gridPane.add(new Label("Guesses Remaining: "), 0, 2);
        guessesRemaining = new Label(String.valueOf(tries));
        gridPane.add(guessesRemaining, 0, 3);

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetGame());
        gridPane.add(resetButton, 1, 3);

        resultLabel = new Label();
        gridPane.add(resultLabel, 0, 4, 2, 1);

        BorderPane thing = new BorderPane();
        thing.setRight(gridPane);
        thing.setCenter(pane);

        tfGuess.setOnAction(e -> playGame());
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(255, 218, 185)), 
                new Stop(1, Color.rgb(230, 230, 250))); 


        thing.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(gradient, null, null)));

        Scene scene = new Scene(thing, 700, 400);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void playGame() {
        String guess = tfGuess.getText();
        if (guess.length() == 0) {
            return;
        }
        if (guess.length() > 1) {
            guess = guess.substring(0, 1);
        }
        guess = guess.toUpperCase();
        tfGuess.setText("");

        if (guessedLetters.length() > 0) {
            if (guessedLetters.indexOf(guess) > -1) {
                return;
            } else {
                guessedLetters.append(guess);
            }
        } else {
            guessedLetters.append(guess);
        }
        tfLettersGuessed.setText(guessedLetters.toString());

        boolean good = false;
        for (int i = 0; i < theWord.length(); i++) {
            if (guess.equalsIgnoreCase(theWord.substring(i, i + 1))) {
                text[i].setVisible(true);
                good = true;
            }
        }

        if (!good) {
            if (tries > 0) {
                body.get(6 - tries).setVisible(true);
                tries--;
                guessesRemaining.setText(String.valueOf(tries));
            }

            if (tries == 0) {
                gameOver(false);
            }
        }

        if (isWordSolved()) {
            gameOver(true);
        } else if (tries == 0) {
            gameOver(false);
        }
    }

    private boolean isWordSolved() {
        for (int i = 0; i < text.length; i++) {
            if (!text[i].isVisible()) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        guessedLetters.setLength(0);
        tfLettersGuessed.clear();
        tries = 6;
        guessesRemaining.setText(String.valueOf(tries));

        for (Shape shape : body) {
            shape.setVisible(false);
        }

        resultLabel.setText("");
        resultLabel.setVisible(false);

        theWord = getHiddenWord().toUpperCase();

        ObservableList<Node> blanksToRemove = children.filtered(node -> node instanceof Line);
        children.removeAll(blanksToRemove);

        Blanks(theWord);

        ObservableList<Node> textToRemove = children.filtered(node -> node instanceof Text);
        children.removeAll(textToRemove);

        text = initText(theWord);
        FrameBorder();
    }

    
    private void gameOver(boolean win) {
        if (win) {
            resultLabel.setText("Congratulations! You guessed the word!");
        } else {
            resultLabel.setText("Game Over. The word was: " + theWord);
        }
        resultLabel.setVisible(true);
    }
}


