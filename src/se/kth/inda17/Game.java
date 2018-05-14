package se.kth.inda17;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    /**
     *
     * Start the application.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("se.kth.inda17.fxml"));
        menu(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * Start menu containing a start and quit button.
     * Click 'start' to start the game and 'quit' to close the window.
     *
     * @param stage
     */
    private void menu(Stage stage) {
        stage.setTitle("Menu");
        Button startButton = new Button("Start");
        Button quitButton = new Button("Quit");

        startButton.setOnAction(event -> startBoxBallGame(stage));
        quitButton.setOnAction(event -> stage.close());

        StackPane root = new StackPane();
        VBox vBox = new VBox(5.0, startButton, quitButton);
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();
    }

    /**
     *
     * Stop the application.
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        // TODO
    }

    /**
     *
     * Create initial JavaFX object, needed in the game.
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        // TODO?
    }

    private void startBoxBallGame(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
    }
}
