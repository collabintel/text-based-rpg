package mad.rpg.game.states;

import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.actions.ActionFactory;
import mad.rpg.game.context.Context;
import mad.rpg.game.transitions.StateTransition;
import mad.rpg.game.transitions.Transition;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilLocator.class})
public class GameStateMachineTest {

    @Mock
    UtilLocator utilLocator;

    @Mock
    Output output;

    @Mock
    Context context;

    @Mock
    ActionFactory actionFactory;

    @Mock
    StateTable stateTable;

    @Mock
    Action action;

    StateMachine stateMachine;

    Transition transitionOne;

    Transition transitionTwo;

    @Before
    public void setUp() throws Exception {
        stateMachine = new GameStateMachine(stateTable, context, actionFactory);
        transitionOne = new StateTransition(StateType.EMPTY_STATE, StateType.GAME_BEGINNING_STATE, null);
        transitionTwo = new StateTransition(StateType.GAME_BEGINNING_STATE, StateType.GAME_ENDING_STATE, null);
    }

    @Test
    public void should_runStateMachine_when_runCalled() throws Exception {
        when(stateTable.availableTransition(StateType.EMPTY_STATE, context)).thenReturn(Optional.of(transitionOne));
        when(stateTable.availableTransition(StateType.GAME_BEGINNING_STATE, context)).thenReturn(Optional.of(transitionTwo));
        when(actionFactory.create(StateType.GAME_BEGINNING_STATE)).thenReturn(action);
        when(actionFactory.create(StateType.GAME_ENDING_STATE)).thenReturn(action);

        stateMachine.run();

        verify(action, times(2)).process(context);
    }

    @Test
    public void should_handleStateNotFoundException_when_stateNotFoundInAvailableTransition() throws Exception {
        when(stateTable.availableTransition(StateType.EMPTY_STATE, context)).thenReturn(Optional.of(transitionOne));
        when(actionFactory.create(StateType.GAME_BEGINNING_STATE)).thenThrow(new StateNotFoundException());
        PowerMockito.mockStatic(UtilLocator.class);
        PowerMockito.when(UtilLocator.locate()).thenReturn(utilLocator);
        when(utilLocator.output()).thenReturn(output);

        stateMachine.run();

        verify(output).printMessage(Messages.STATE_NOT_FOUND_EXCEPTION_MESSAGE);
        verify(output).printMessage(Messages.UNHANDLED_OPERATION);
    }
}
