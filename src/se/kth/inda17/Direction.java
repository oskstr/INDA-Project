package se.kth.inda17;

import javafx.geometry.Point2D;

public enum Direction {
    // TODO
    RIGHT(new Point2D(1,0));

    public Point2D vector;

    Direction(Point2D vector) {
        this.vector = vector;
    }
}
