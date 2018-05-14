package se.kth.inda17.test;

import javafx.geometry.Point2D;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import se.kth.inda17.Player;
import se.kth.inda17.Plutten;

public class GameTest {
    private Player player;
    private int width = 600;
    private int height = 600;

    @Before
    public void init() {
        player = new Player("player.png", new Point2D(10,10), width, height);
    }

    @Test
    public void testPlayerGettingOutOfBounds() {
        player.move(new Point2D(-20,0));

        assertThat(player.isOutOfBounds(),is(true));
    }

    @Test
    public void testPluttenCollideWithWall() {
        Plutten plutten = new Plutten("plutten.png", new Point2D(0,0), width, height);
        plutten.setDirection(new Point2D(-1,0));
        plutten.setSpeed(1);
        plutten.update();

        // TODO
    }


}
