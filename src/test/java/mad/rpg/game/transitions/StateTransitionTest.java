package mad.rpg.game.transitions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.states.StateType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

public class StateTransitionTest {

    Transition transition;

    Context context;

    @Mock
    Condition condition;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        transition = new StateTransition(StateType.GAME_BEGINNING_STATE, StateType.GAME_ENDING_STATE, condition);
        context = new GameContext();
    }

    @Test
    public void should_getBeginningState_when_fromCalled() throws Exception {
        StateType from = transition.from();
        assertThat(from).isEqualTo(StateType.GAME_BEGINNING_STATE);
    }

    @Test
    public void should_getEndingState_when_toCalled() throws Exception {
        StateType to = transition.to();
        assertThat(to).isEqualTo(StateType.GAME_ENDING_STATE);
    }

    @Test
    public void should_conditionResult_when_conditionCalled() throws Exception {
        Boolean expectedResult = true;

        when(condition.test(context)).thenReturn(expectedResult);

        Boolean result = transition.condition(context);
        assertThat(result).isEqualTo(expectedResult);
    }

}
