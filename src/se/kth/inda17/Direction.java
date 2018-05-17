package se.kth.inda17;

import javafx.geometry.Point2D;

/**
 * Define directions as Euclidean vectors in 2D space.
 */
public enum Direction {
    RIGHT(new Point2D(1,0)),
    LEFT(new Point2D(-1,0)),
    UP(new Point2D(0,-1)),
    DOWN(new Point2D(0,1)),
    NONE(new Point2D(0,0));


    public Point2D vector;

    Direction(Point2D vector) {
        this.vector = vector;
    }
}
