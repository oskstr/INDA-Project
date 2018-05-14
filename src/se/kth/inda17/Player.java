package se.kth.inda17;

import javafx.geometry.Point2D;

public class Player extends Character {
    private boolean alive;

    public Player(String image, Point2D position, int boundaryWidth, int boundaryHeight) {
        super(image, position, boundaryWidth, boundaryHeight);
        alive = true;
    }

    public void move(Point2D direction) {
        Point2D position = getPosition();
        setPosition(position.add(direction));
    }

    public boolean isDead() {
        return !alive;
    }
}
