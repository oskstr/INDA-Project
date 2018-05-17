package se.kth.inda17;

import javafx.geometry.Point2D;

import java.util.HashMap;

public class Player extends Character {
    private static final String image = "/images/player.png";
    private static int width = 50;
    private static int height = 50;

    private HashMap<Integer, String> grades = new HashMap<>();
    private int grade = 0;

    public Player(Point2D position, int boundaryWidth, int boundaryHeight) {
        super(image, width, height, position, boundaryWidth, boundaryHeight);

        // Set up grades
        grades.put(0, "A");
        grades.put(1, "B");
        grades.put(2, "C");
        grades.put(3, "D");
        grades.put(4, "E");
        grades.put(5, "F");
    }

    public void move(Point2D direction) {
        Point2D position = getPosition();
        int speed = 5;
        setPosition(position.add(direction.multiply(speed)));
        stayInBounds();
    }

    void getsKomplettering() {
        if (grade < 5) {
            grade++;
        }
    }

    String getGrade() {
        return grades.get(grade);
    }

    public boolean failed() {
        return grade == 5;
    }
}
