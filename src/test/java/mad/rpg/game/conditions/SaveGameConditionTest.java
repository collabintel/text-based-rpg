package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SaveGameConditionTest {

    Condition saveGameCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        saveGameCondition = new SaveGameCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_saveGameEventConditionCalled() throws Exception {
        context.addEvent(EventType.SAVE_GAME);

        Boolean result = saveGameCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherEventsCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = saveGameCondition.test(context);

        assertThat(result).isEqualTo(false);
    }
}
