package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterCreationEndConditionTest {

    Condition characterCreationEndCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        characterCreationEndCondition = new CharacterCreationEndCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_characterCreatedEventCalled() throws Exception {
        context.addEvent(EventType.CHARACTER_CREATED);

        Boolean result = characterCreationEndCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnTrue_when_characterNotCreatedEventCalled() throws Exception {
        context.addEvent(EventType.CHARACTER_NOT_CREATED);

        Boolean result = characterCreationEndCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnTrue_when_exitRequestedEventCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = characterCreationEndCondition.test(context);

        assertThat(result).isEqualTo(false);
    }

}
