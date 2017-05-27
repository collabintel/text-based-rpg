package mad.rpg.world.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoomTest {

    private static final Integer X = 0;
    private static final Integer Y = 2;

    Location room;

    @Before
    public void setUp() throws Exception {
        room = new Room(X, Y);
    }

    @Test
    public void should_xValue_when_getXCalled() throws Exception {
        Integer x = room.getX();

        assertThat(x).isEqualTo(X);
    }

    @Test
    public void should_yValue_when_getYCalled() throws Exception {
        Integer y = room.getY();

        assertThat(y).isEqualTo(Y);
    }
}
