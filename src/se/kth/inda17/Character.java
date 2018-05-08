package se.kth.inda17;

import javafx.geometry.Point2D;

abstract class Character {
    private Point2D position;

    Character(Point2D position) {
        this.position = position;
    }

    public Point2D getPosition() {
        return position;
    }

    void setPosition(Point2D position) {
        this.position = position;
    }

    public abstract boolean isOutOfBounds(int width, int height);
}
