package se.kth.inda17;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private Direction userDirection = Direction.NONE;

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
        Label title = new Label("Welcome to world of INDA17");

        startButton.setOnAction(event -> startBoxBallGame(stage));
        quitButton.setOnAction(event -> stage.close());
        startButton.setId("startButton");
        quitButton.setId("quitButton");
        title.setId("title");

        StackPane root = new StackPane();
        root.setId("pane");
        VBox vBox = new VBox(5.0, title, startButton, quitButton);
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
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
        stage.hide();
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inda 17 - The Game");

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        root.getChildren().add(canvas);

        handleUserInput(scene);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Player player = new Player(new Point2D(WIDTH/2, HEIGHT/2), WIDTH, HEIGHT);
        ArrayList<Plutten> pluttens = new ArrayList<>();
        pluttens.add(new Plutten(WIDTH, HEIGHT));

        stage.show();
        new AnimationTimer() {
            long currentTime = System.nanoTime();
            @Override
            public void handle(long now) {
                gc.clearRect(0,0,WIDTH,HEIGHT);
                player.render(gc);
                player.move(userDirection.vector);

                if (now - currentTime > 5e9) {
                    pluttens.add(new Plutten(WIDTH, HEIGHT));
                    currentTime = System.nanoTime();
                }

                for (Plutten plutten : pluttens) {
                    plutten.render(gc);
                    plutten.update();
                    if (player.isCollidingWith(plutten)) {
                        player.dies();
                        //stop();
                    }
                }

            }
        }.start();
    }

    /**
     * Set the direction of the player using user input.
     * @param scene
     */
    private void handleUserInput(Scene scene) {
        scene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            if (key == KeyCode.LEFT)  userDirection = Direction.LEFT;
            if (key == KeyCode.RIGHT) userDirection = Direction.RIGHT;
            if (key == KeyCode.DOWN)  userDirection = Direction.DOWN;
            if (key == KeyCode.UP)    userDirection = Direction.UP;
        });

        scene.setOnKeyReleased(event -> {
            KeyCode key = event.getCode();
            if (key == KeyCode.LEFT  && userDirection == Direction.LEFT)  userDirection = Direction.NONE;
            if (key == KeyCode.RIGHT && userDirection == Direction.RIGHT) userDirection = Direction.NONE;
            if (key == KeyCode.DOWN  && userDirection == Direction.DOWN)  userDirection = Direction.NONE;
            if (key == KeyCode.UP    && userDirection == Direction.UP)    userDirection = Direction.NONE;
        });
    }
}
