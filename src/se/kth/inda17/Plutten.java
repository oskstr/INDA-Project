package se.kth.inda17;

import javafx.geometry.Point2D;

public class Plutten extends Character {
    private Point2D direction;
    private int speed;

    public Plutten(Point2D position) {
        super(position);
        speed = getRandomSpeed();
        direction = getRandomDirection();
    }

    public Plutten() {
        this(new Point2D(0,0));
        this.setPosition(getRandomPosition());
    }

    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void update() {
        // TODO
    }

    @Override
    public boolean isOutOfBounds(int width, int height) {
        // TODO
        return false;
    }

    private int getRandomSpeed() {
        // TODO
        return 1;
    }

    private Point2D getRandomDirection() {
        // TODO
        return new Point2D(1,1);
    }

    private Point2D getRandomPosition() {
        // TODO
        return new Point2D(0,0);
    }
}
