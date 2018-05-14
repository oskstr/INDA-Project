package se.kth.inda17;

import javafx.geometry.Point2D;

import java.util.Random;

public class Plutten extends Character {
    private Point2D direction;
    private int speed;
    private Random random = new Random();

    public Plutten(String image, Point2D position, int boundaryWidth, int boundaryHeight) {
        super(image, position, boundaryWidth, boundaryHeight);
        speed = getRandomSpeed();
        direction = getRandomDirection();
    }

    public Plutten(String image, int boundaryWidth, int boundaryHeight) {
        this(image, new Point2D(0,0), boundaryWidth, boundaryHeight);
        setPosition(getRandomPosition());
    }

    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void update() {
        Point2D position = getPosition();
        setPosition(position.add(direction.getX()*speed, direction.getY()*speed));
    }

    private int getRandomSpeed() {
        return random.nextInt(10);
    }

    private Point2D getRandomDirection() {
        int x = random.nextInt(10)-5;
        int y = random.nextInt(10)-5;

        return new Point2D(x,y);
    }

    private Point2D getRandomPosition() {
        // TODO
        return new Point2D(0,0);
    }
}
