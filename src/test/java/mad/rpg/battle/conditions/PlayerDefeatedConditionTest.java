package mad.rpg.battle.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerDefeatedConditionTest {

    Condition playerDefeatedCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        playerDefeatedCondition = new PlayerDefeatedCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_playerDefeatedEventConditionCalled() throws Exception {
        context.addEvent(EventType.PLAYER_DEFEATED);

        Boolean result = playerDefeatedCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherEventsCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = playerDefeatedCondition.test(context);

        assertThat(result).isEqualTo(false);
    }
}
