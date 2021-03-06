package se.kth.inda17;

import javafx.geometry.Point2D;

import java.util.Random;

public class Plutten extends Character {
    private Point2D direction;
    private double speed;
    private static Random random = new Random();

    private static final String IMAGE = "/images/plutten.png";
    private static final int WIDTH = 30;
    private static final int HEIGHT = 50;


    public Plutten(Point2D position, int boundaryWidth, int boundaryHeight) {
        super(IMAGE, WIDTH, HEIGHT, position, boundaryWidth, boundaryHeight);
        speed = 1;
        direction = getRandomDirection();
    }

    public Plutten(int boundaryWidth, int boundaryHeight) {
        this(getRandomPosition(), boundaryWidth, boundaryHeight);
    }

    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Set a new position. Change direction if a wall is hit.
     */
    public void update() {
        Point2D position = getPosition();
        setPosition(position.add(direction.getX()*speed, direction.getY()*speed));
        if (isOutOfBounds()) flipDirection();
    }

    /**
     * If player hits a wall, change to the opposite direction in the axis of impact.
     */
    private void flipDirection() {
        double x = getPosition().getX();
        double y = getPosition().getY();

        if (x < 0 || x + WIDTH > getBoundaryWidth()) {
            direction = new Point2D(-direction.getX(), direction.getY());
        }

        if (y < 0 || y + HEIGHT > getBoundaryHeight()) {
            direction = new Point2D(direction.getX(), -direction.getY());
        }

        stayInBounds();
    }

    /**
     * Get a random, normalized Euclidean vector that determine direction
     * @return vector to represent direction.
     */
    private Point2D getRandomDirection() {
        double x = random.nextInt(1000)-500;
        double y = random.nextInt(1000)-500;

        while (x == 0 && y == 0) {
            x = random.nextInt(1000)-500;
            y = random.nextInt(1000)-500;
        }

        return new Point2D(x,y).normalize();
    }

    /**
     * Get a random position within the allowed boundaries.
     * @return
     */
    private static Point2D getRandomPosition() {
        int x = random.nextInt(getBoundaryWidth());
        int y = random.nextInt(getBoundaryHeight());

        return new Point2D(x,y);
    }

    double getSpeed() {
        return speed;
    }
}
