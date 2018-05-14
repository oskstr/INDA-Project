package se.kth.inda17;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

abstract class Character {
    private Image image;
    private Point2D position;
    private int boundaryWidth;
    private int boundaryHeight;

    Character(String image, Point2D position, int boundaryWidth, int boundaryHeight) {
        this.position = position;
        this.boundaryWidth = boundaryWidth;
        this.boundaryHeight = boundaryHeight;
        this.image = new Image(image);
    }

    public Point2D getPosition() {
        return position;
    }

    void setPosition(Point2D position) {
        this.position = position;
    }

    public boolean isOutOfBounds() {
        return (position.getX() < 0             || position.getY() < 0               ||
                position.getX() > boundaryWidth || position.getY() > boundaryHeight);
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
    }

    private Rectangle2D getBoundary() {
        return new Rectangle2D(position.getX(), position.getY(), image.getWidth(), image.getHeight());
    }

    public boolean isCollidingWith(Character c) {
        return getBoundary().intersects(c.getBoundary());
    }
}
