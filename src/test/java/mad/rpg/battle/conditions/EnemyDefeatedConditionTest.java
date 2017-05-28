package mad.rpg.battle.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyDefeatedConditionTest {

    Condition enemyDefeatedCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        enemyDefeatedCondition = new EnemyDefeatedCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_enemyDefeatedEventConditionCalled() throws Exception {
        context.addEvent(EventType.ENEMY_DEFEATED);

        Boolean result = enemyDefeatedCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherEventsCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = enemyDefeatedCondition.test(context);

        assertThat(result).isEqualTo(false);
    }

}
