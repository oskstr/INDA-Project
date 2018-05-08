package se.kth.inda17;


import javafx.geometry.Point2D;

public class Player extends Character {
    private boolean alive;

    public Player(Point2D position) {
        super(position);
        alive = true;
    }

    public void move(Point2D direction) {
        // TODO
    }

    public boolean isCollidingWith(Plutten plutten) {
        // TODO
        return false;
    }

    public boolean isDead() {
        // TODO
        return false;
    }

    @Override
    public boolean isOutOfBounds(int width, int height) {
        // TODO
        return false;
    }
}
