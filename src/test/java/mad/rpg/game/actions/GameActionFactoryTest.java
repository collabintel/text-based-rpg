package mad.rpg.game.actions;

import mad.rpg.characters.actions.ChooseCharacterAction;
import mad.rpg.characters.actions.CreateCharacterAction;
import mad.rpg.game.Messages;
import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameActionFactoryTest {

    EventFactory stateFactory;

    @Before
    public void setUp() throws Exception {
        stateFactory = new GameEventFactory();
    }

    @Test
    public void should_throwStateNotFoundException_when_createStateWithNullParameterCalled() throws Exception {
        assertThatThrownBy(() -> { stateFactory.createEvent(null); })
                .isInstanceOf(StateNotFoundException.class)
                .withFailMessage(Messages.STATE_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_createStartGameState_when_createStateWithStartGameStateTypeCalled() throws Exception {
        Action startGameState = stateFactory.createEvent(StateType.GAME_BEGINNING_STATE);
        assertThat(startGameState).isInstanceOf(BeginGameAction.class);
    }

    @Test
    public void should_createExitGameState_when_createStateWithExitGameStateTypeCalled() throws Exception {
        Action exitGameState = stateFactory.createEvent(StateType.GAME_ENDING_STATE);
        assertThat(exitGameState).isInstanceOf(EndGameAction.class);
    }

    @Test
    public void should_createChooseCharacterState_when_createStateWithChooseCharacterStateTypeCalled() throws Exception {
        Action chooseCharacterState = stateFactory.createEvent(StateType.CHARACTER_LISTING_STATE);
        assertThat(chooseCharacterState).isInstanceOf(ChooseCharacterAction.class);
    }

    @Test
    public void should_createCreateCharacterState_when_createStateWithCreateCharacterStateTypeCalled() throws Exception {
        Action createCharacterState = stateFactory.createEvent(StateType.CHARACTER_CREATING_STATE);
        assertThat(createCharacterState).isInstanceOf(CreateCharacterAction.class);
    }
}
