package se.kth.inda17;

import javafx.geometry.Point2D;

import java.util.Random;

public class Plutten extends Character {
    private Point2D direction;
    private int speed;
    private Random random = new Random();

    public Plutten(Point2D position) {
        super(position);
        speed = getRandomSpeed();
        direction = getRandomDirection();
    }

    public Plutten() {
        this(new Point2D(0,0));
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
