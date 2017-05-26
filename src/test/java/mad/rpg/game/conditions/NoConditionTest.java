package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import org.junit.Before;
import org.junit.Test;

public class NoConditionTest {

    Condition noCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        noCondition = new NoCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_testCalled() throws Exception {
        noCondition.test(context);
    }
}
