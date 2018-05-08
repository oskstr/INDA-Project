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
    private int width;
    private int height;
    private Point2D boxPosition;

    @Before
    public void init() {
        player = new Player(new Point2D(10,10));
    }

    @Test
    public void testPlayerGettingOutOfBounds() {
        player.move(new Point2D(-20,0));

        assertThat(player.isOutOfBounds(500,500),is(true));
    }

    @Test
    public void testPluttenCollideWithWall() {
        Plutten plutten = new Plutten(new Point2D(0,0));
        plutten.setDirection(new Point2D(-1,0));
        plutten.setSpeed(1);
        plutten.update();

        // TODO
    }


}
