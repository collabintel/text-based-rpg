package mad.rpg.world.model;

import mad.rpg.characters.model.Enemy;
import mad.rpg.characters.model.HostileCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RoomTest {

    private static final Integer X = 0;
    private static final Integer Y = 2;

    Location room;

    Optional<HostileCharacter> enemy;

    @Before
    public void setUp() throws Exception {
        enemy = Optional.of(new Enemy(null, null));
        room = new Room(X, Y, enemy);
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

    @Test
    public void should_getEnemy_when_enemyCalled() throws Exception {
        Optional<HostileCharacter> enemyActual = room.hostile();

        assertThat(enemyActual).isEqualTo(enemy);
    }
}
