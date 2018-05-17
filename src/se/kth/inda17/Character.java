package se.kth.inda17;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The Character class handles the image, position, width and height of all characters.
 * It also keeps track of the outer boundaries of the window and keeps the characters
 * within the allowed limits.
 */
abstract class Character {
    private Image image;
    private int width;
    private int height;

    private Point2D position;

    // Size of window
    private static int boundaryWidth;
    private static int boundaryHeight;

    Character(String image, int width, int height, Point2D position, int boundaryWidth, int boundaryHeight) {
        this.position = position;

        Character.boundaryWidth = boundaryWidth;
        Character.boundaryHeight = boundaryHeight;

        this.image = new Image(getResource(image));
        this.width = width;
        this.height = height;
    }

    public Point2D getPosition() {
        return position;
    }

    void setPosition(Point2D position) {
        this.position = position;
    }

    public boolean isOutOfBounds() {
        return (position.getX() < 0                     || position.getY() < 0                        ||
                position.getX() + width > boundaryWidth || position.getY() + height > boundaryHeight);
    }

    /**
     * Keeps the character within the allowed bounds.
     */
    void stayInBounds() {
        if (isOutOfBounds()) {
            double x = position.getX();
            double y = position.getY();
            double w = boundaryWidth - width;
            double h = boundaryHeight - height;

            if (x < 0)  setPosition(new Point2D(0,position.getY()));
            if (x > w)  setPosition(new Point2D(w,position.getY()));
            if (y < 0)  setPosition(new Point2D(position.getX(),0));
            if (y > h)  setPosition(new Point2D(position.getX(),h));
        }
    }

    /**
     * Draws the image on screen at the character's position.
     * @param gc Graphics context of the canvas to draw on
     */
    void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY(), width, height);
    }

    private Rectangle2D getBoundary() {
        return new Rectangle2D(position.getX(), position.getY(), width, height);
    }

    /**
     * Collision detection between characters
     * @param c Some other character to detect collisions with.
     * @return true if colliding, false otherwise
     */
    public boolean isCollidingWith(Character c) {
        return getBoundary().intersects(c.getBoundary());
    }

    private static String getResource(String filename) {
        return Character.class.getResource(filename).toString();
    }

    static int getBoundaryWidth() {
        return boundaryWidth;
    }

    static int getBoundaryHeight() {
        return boundaryHeight;
    }
}