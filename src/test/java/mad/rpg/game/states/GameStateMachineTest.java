//package mad.rpg.game.states;
//
//import mad.rpg.game.context.Context;
//import mad.rpg.game.actions.BeginGameAction;
//import mad.rpg.game.actions.Action;
//import mad.rpg.game.actions.EventFactory;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//
//import static org.mockito.Mockito.when;
//
//public class GameStateMachineTest {
//
//    @Mock
//    Context context;
//
//    @Mock
//    EventFactory eventFactory;
//
//    @Mock
//    StateTable stateTable;
//
//    @Mock
//    Action event;
//
//    StateMachine stateMachine;
//
//    @Before
//    public void setUp() throws Exception {
//        stateMachine = new GameStateMachine(stateTable, context, eventFactory);
//    }
//
//    /**
//     * StateScenarioOne
//     *
//     * GameBeginningState
//     * CharacterListingState
//     * CharacterCreatingState
//     * CharacterListingState
//     * GameEndingState
//     *
//     * @throws Exception
//     */
//    @Test
//    public void should_runStateMachineScenarioOne_when_runCalled() throws Exception {
//
//    }
//}
