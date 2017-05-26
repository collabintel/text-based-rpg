package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExitRequestedConditionTest {

    Condition exitRequestedCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        exitRequestedCondition = new ExitRequestedCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_testInputExit() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);
        Boolean result = exitRequestedCondition.test(context);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_testInputNotExit() throws Exception {
        context.addEvent(EventType.GAME_STARTED);
        Boolean result = exitRequestedCondition.test(context);
        assertThat(result).isEqualTo(false);
    }
}
