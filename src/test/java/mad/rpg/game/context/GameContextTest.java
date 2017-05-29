package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.characters.model.Player;
import mad.rpg.game.events.EventType;
import mad.rpg.world.model.Dungeon;
import mad.rpg.world.model.Room;
import mad.rpg.world.model.World;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class GameContextTest {

    Context gameContext;

    @Before
    public void setUp() throws Exception {
        gameContext = new GameContext();
    }

    @Test
    public void should_getEvents_when_exitRequestedEventAddedAndEventsCalled() throws Exception {
        gameContext.addEvent(EventType.EXIT_REQUESTED);
        List<EventType> events = gameContext.events();

        assertThat(events).hasSize(1);
        assertThat(events.get(0)).isEqualTo(EventType.EXIT_REQUESTED);
    }

    @Test
    public void should_addExitRequestedEvent_when_addEventCalled() throws Exception {
        gameContext.addEvent(EventType.EXIT_REQUESTED);
        EventType lastEvent = gameContext.getLastEvent();

        assertThat(lastEvent).isEqualTo(EventType.EXIT_REQUESTED);
    }

    @Test
    public void should_getPlayer_when_aPlayerSetAndGetPlayerCalled() throws Exception {
        Character player = new Player(null, null);
        gameContext.withPlayer(player);
        Character actualPlayer = gameContext.getPlayer();

        assertThat(actualPlayer).isEqualTo(player);
    }

    @Test
    public void should_getWorld_when_aWorldSetAndGetPlayerCalled() throws Exception {
        World world = new Dungeon(new Room[][] { { new Room(0, 0, Optional.empty()) } });
        gameContext.withWorld(world);
        World actualWorld = gameContext.getWorld();

        assertThat(actualWorld).isEqualTo(world);
    }
}
