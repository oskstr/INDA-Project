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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
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

    private void startBoxBallGame(Stage stage) {
        stage.hide();
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inda 17 - The Game");

        handleUserInput(scene);

        Player player = new Player(new Point2D(WIDTH/2, HEIGHT/2), WIDTH, HEIGHT);
        ArrayList<Plutten> pluttens = new ArrayList<>();
        pluttens.add(new Plutten(WIDTH, HEIGHT));

        Label week = new Label("Weekly assignment 1");
        week.setTranslateX(10);
        week.setTranslateY(10);
        week.setId("week");

        Label grade = new Label("Grade: " + player.getGrade());
        grade.setTranslateX(WIDTH-110);
        grade.setTranslateY(10);
        grade.setId("grade");

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        root.getChildren().addAll(canvas, week, grade);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.show();

        new AnimationTimer() {
            long startTime = System.nanoTime();
            long kompletteringTime = System.nanoTime();
            double speed = pluttens.get(0).getSpeed();
            int weekNum = 1;

            @Override
            public void handle(long now) {
                paintBackground(gc);

                player.render(gc);
                player.move(userDirection.vector);

                if (now - startTime > 5e9) { // 5 seconds
                    startTime = now; // reset time
                    speed = increasePluttenSpeed(pluttens, speed);
                    weekNum = updateWeek(weekNum, week);

                    if (weekNum > 27) {
                        gameOver(stage, true);
                        stop();
                    }

                    increasePlutten(pluttens, weekNum);
                }

                for (Plutten plutten : pluttens) {
                    plutten.render(gc);
                    plutten.update();

                    if (player.isCollidingWith(plutten) && now - kompletteringTime > 1e9 ) {
                        player.getsKomplettering();
                        grade.setText("Grade: " + player.getGrade());
                        kompletteringTime = now;

                        if (player.failed()) {
                            gameOver(stage, false);
                            stop();
                        }
                    }
                }
            }
        }.start();
    }

    private void paintBackground(GraphicsContext gc) {
        Stop[] stops = new Stop[] { new Stop(0, Color.CYAN), new Stop(1, Color.MAGENTA)};
        gc.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops));
        gc.fillRect(0,0, WIDTH, HEIGHT);
    }

    private double increasePluttenSpeed(ArrayList<Plutten> pluttens, double speed) {
        speed+=0.15;
        for (Plutten plutten : pluttens) {
            plutten.setSpeed(speed); // increase speed
        }
        return speed;
    }

    private int updateWeek(int weekNum, Label week) {
        weekNum++; // increase level

        if (weekNum < 19) {
            week.setText("Weekly assignment " + weekNum);
        } else if (weekNum == 19 || weekNum == 20) {
            week.setText("Weekly assignment Quicksort" );
        } else if (weekNum <= 23) {
            week.setText("Palinda " + (weekNum - 20) );
        } else if (weekNum == 24) {
            week.setText("Projinda Week 1: Plan");
        } else if (weekNum == 25) {
            week.setText("Projinda Week 2: Develop");
        } else if (weekNum == 26) {
            week.setText("Projinda Week 3: Review");
        } else if (weekNum == 27) {
            week.setText("Projinda Week 4: Demo");
        }
        return weekNum;
    }

    private void increasePlutten(ArrayList<Plutten> pluttens, int weekNum) {
        if (weekNum % 3 == 0) { // increase plutten every 3th level
            pluttens.add(new Plutten(WIDTH, HEIGHT));
        }
    }

    private void gameOver(Stage gameStage, boolean complete) {
        Stage stage = new Stage();

        Button menuButton = new Button("Menu");
        Button quitButton = new Button("Quit");
        Button omregButton = new Button("Omregistrera");

        menuButton.setId("menuButton");
        quitButton.setId("quitButtonGameOver");
        omregButton.setId("omregButton");

        menuButton.setOnAction(event -> {
            stage.close();
            menu(gameStage);
        });

        quitButton.setOnAction(event -> {
            stage.close();
            gameStage.close();
        });

        omregButton.setOnAction(event -> {
            stage.close();
            startBoxBallGame(gameStage);
        });

        stage.setOnCloseRequest(event -> {
            stage.close();
            menu(gameStage);
        });

        Label label = new Label();
        label.setId("gameOverText");

        VBox vBox = new VBox(5.0, label);
        vBox.setId("gameOver");
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(350);
        vBox.setPrefHeight(250);

        HBox hBox = new HBox(8.0);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(menuButton, quitButton);

        if (complete) {
            stage.setTitle("INDA 17 Complete!");
            label.setText("You passed INDA 17! Congratulations!");
        } else {
            stage.setTitle("Game Over");
            label.setText("You failed!");
            vBox.getChildren().add(omregButton);
        }

        vBox.getChildren().add(hBox);


        Scene scene = new Scene(vBox);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
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
