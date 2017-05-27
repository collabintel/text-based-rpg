package mad.rpg.characters.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterCreationBeginConditionTest {

    Condition characterCreationBeginCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        characterCreationBeginCondition = new CharacterCreationBeginCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_characterCreationRequestEventConditionCalled() throws Exception {
        context.addEvent(EventType.CHARACTER_CREATION_REQUEST);

        Boolean result = characterCreationBeginCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherCommandsCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = characterCreationBeginCondition.test(context);

        assertThat(result).isEqualTo(false);
    }
}
