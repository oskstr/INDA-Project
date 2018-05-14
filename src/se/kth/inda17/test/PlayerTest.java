package se.kth.inda17.test;

import javafx.geometry.Point2D;
import org.junit.Before;
import org.junit.Test;
import se.kth.inda17.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class PlayerTest {
    private Player player;
    private Plutten plutten;

    @Before
    public void init() {
        int width = 600;
        int height = 600;

        player = new Player(new Point2D(10, 10), width, height);
        plutten = new Plutten(new Point2D(10, 10), width, height);
    }

    @Test
    public void testPlayerMoves() {
        for (Direction direction : Direction.values()) {
            Point2D oldPosition = player.getPosition();
            player.move(direction.vector);
            assertThat(player.getPosition(), equalTo(oldPosition.add(direction.vector)));
        }
    }

    @Test
    public void testPluttenCollision() {
        assertThat(player.isCollidingWith(plutten), is(true));
    }

    @Test
    public void testPluttenMoves() {
        Point2D oldPosition = plutten.getPosition();

        plutten.setDirection(new Point2D(1,1));
        plutten.setSpeed(1);
        plutten.update();

        assertThat(plutten.getPosition(), equalTo(oldPosition.add(1,1)));
    }

    @Test
    public void testPlayerDies() {
        player.isCollidingWith(plutten);
        assertThat(player.isAlive(), is(false));
    }

}
