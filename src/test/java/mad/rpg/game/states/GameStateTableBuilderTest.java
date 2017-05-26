package mad.rpg.game.states;

import mad.rpg.game.transitions.Transition;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class GameStateTableBuilderTest {

    StateTableBuilder stateTableBuilder;

    @Before
    public void setUp() throws Exception {
        stateTableBuilder = new GameStateTableBuilder();
    }

    @Test
    public void should_buildStateTable_when_buildCalled() throws Exception {
        StateTable stateTable = stateTableBuilder.build();

        assertThat(stateTable)
                .isNotNull()
                .isInstanceOf(GameStateTable.class);

        List<Transition> transitions = stateTable.transitions();

        assertThat(transitions)
                .extracting(x -> x.from(), x -> x.to())
                .contains(tuple(StateType.EMPTY_STATE, StateType.GAME_BEGINNING_STATE))
                .contains(tuple(StateType.GAME_BEGINNING_STATE, StateType.CHARACTER_LISTING_STATE))
                .contains(tuple(StateType.CHARACTER_LISTING_STATE, StateType.GAME_ENDING_STATE))
                .contains(tuple(StateType.CHARACTER_LISTING_STATE, StateType.CHARACTER_CREATING_STATE))
                .contains(tuple(StateType.CHARACTER_CREATING_STATE, StateType.CHARACTER_LISTING_STATE))
                .contains(tuple(StateType.CHARACTER_CREATING_STATE, StateType.GAME_ENDING_STATE));
    }
}
