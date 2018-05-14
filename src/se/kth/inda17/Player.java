package se.kth.inda17;

import javafx.geometry.Point2D;

public class Player extends Character {
    private boolean alive;

    private static final String image = "/images/player.png";
    private static int width = 50;
    private static int height = 50;

    public Player(Point2D position, int boundaryWidth, int boundaryHeight) {
        super(image, width, height, position, boundaryWidth, boundaryHeight);
        alive = true;
    }

    public void move(Point2D direction) {
        Point2D position = getPosition();
        int speed = 7;
        setPosition(position.add(direction.multiply(speed)));
        stayInBounds();
    }

    public boolean isDead() {
        return !alive;
    }
}
