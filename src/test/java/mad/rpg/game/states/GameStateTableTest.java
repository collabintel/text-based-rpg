package mad.rpg.game.states;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.transitions.StateTransition;
import mad.rpg.game.transitions.Transition;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameStateTableTest {

    StateTable stateTable;

    List<Transition> transitions;

    Context context;

    @Mock
    Condition noCondition;

    @Mock
    Condition exitRequestedCondition;

    @Mock
    Condition characterCreationBeginCondition;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        transitions = new ArrayList<>();
        transitions.add(new StateTransition(StateType.GAME_BEGINNING_STATE, StateType.CHARACTER_LISTING_STATE, noCondition));
        transitions.add(new StateTransition(StateType.CHARACTER_LISTING_STATE, StateType.GAME_ENDING_STATE, exitRequestedCondition));
        transitions.add(new StateTransition(StateType.CHARACTER_LISTING_STATE, StateType.CHARACTER_CREATING_STATE, characterCreationBeginCondition));
        stateTable = new GameStateTable(transitions);
        context = new GameContext();
    }

    @Test
    public void should_returnTransitions_when_transitionsCalled() throws Exception {
        List<Transition> transitions = stateTable.transitions();

        assertThat(transitions)
                .hasSize(3)
                .extracting(transition -> transition.from(), transition -> transition.to())
                .contains(tuple(StateType.GAME_BEGINNING_STATE, StateType.CHARACTER_LISTING_STATE))
                .contains(tuple(StateType.CHARACTER_LISTING_STATE, StateType.GAME_ENDING_STATE))
                .contains(tuple(StateType.CHARACTER_LISTING_STATE, StateType.CHARACTER_CREATING_STATE));
    }

    @Test
    public void should_returnAvailableTransitionBasedOnCondition_when_availableTransitionCalled() throws Exception {
        when(noCondition.test(context)).thenReturn(true);

        Optional<Transition> availableTransition = stateTable.availableTransition(StateType.GAME_BEGINNING_STATE, context);

        assertThat(availableTransition.get())
                .matches(transition -> transition.from().equals(StateType.GAME_BEGINNING_STATE))
                .matches(transition -> transition.to().equals(StateType.CHARACTER_LISTING_STATE));

        verify(noCondition).test(context);
    }

    @Test
    public void should_returnAvailableTransitionBasedOnWorkingCondition_when_availableTransitionCalled() throws Exception {
        when(exitRequestedCondition.test(context)).thenReturn(true);
        when(characterCreationBeginCondition.test(context)).thenReturn(false);

        Optional<Transition> availableTransition = stateTable.availableTransition(StateType.CHARACTER_LISTING_STATE, context);

        assertThat(availableTransition.get())
                .matches(transition -> transition.from().equals(StateType.CHARACTER_LISTING_STATE))
                .matches(transition -> transition.to().equals(StateType.GAME_ENDING_STATE));

        verify(exitRequestedCondition).test(context);
    }

    @Test
    public void should_returnEmptyTransition_when_noAvailableTransitionFound() throws Exception {
        Optional<Transition> availableTransition = stateTable.availableTransition(StateType.GAME_ENDING_STATE, context);

        assertThat(availableTransition.isPresent()).isEqualTo(false);
    }

}
