package mad.rpg.characters.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterSelectedConditionTest {

    Condition characterSelectedCondition;

    Context gameContext;

    @Before
    public void setUp() throws Exception {
        characterSelectedCondition = new CharacterSelectedCondition();
        gameContext = new GameContext();
    }

    @Test
    public void should_returnTrue_when_characterSelectedEventConditionCalled() throws Exception {
        gameContext.addEvent(EventType.CHARACTER_SELECTED);

        Boolean result = characterSelectedCondition.test(gameContext);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherCommandsCalled() throws Exception {
        gameContext.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = characterSelectedCondition.test(gameContext);

        assertThat(result).isEqualTo(false);
    }
}
