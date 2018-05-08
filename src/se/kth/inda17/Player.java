package se.kth.inda17;

import javafx.geometry.Point2D;

public class Player extends Character {
    private boolean alive;

    public Player(Point2D position) {
        super(position);
        alive = true;
    }

    public void move(Point2D direction) {
        Point2D position = getPosition();
        setPosition(position.add(direction));
    }

    public boolean isCollidingWith(Plutten plutten) {
        if (getPosition().equals(plutten.getPosition())) {
            alive = false;
            return true;
        }
        return false;
    }

    public boolean isDead() {
        return !alive;
    }
}
