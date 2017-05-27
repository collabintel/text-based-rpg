//package mad.rpg.game.states;
//
//import mad.rpg.game.actions.GameActionFactory;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.powermock.api.mockito.PowerMockito.*;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({GameStateTableBuilder.class, GameActionFactory.class, GameStateMachine.class})
//public class GameStateMachineBuilderTest {
//
//    @Mock
//    GameStateTableBuilder gameStateTableBuilder;
//
//    @Mock
//    GameActionFactory gameEventFactory;
//
//    @Mock
//    StateTable stateTable;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void should_buildStateMachine_when_buildCalled() throws Exception {
//        mockStatic(GameStateTableBuilder.class);
//        mockStatic(GameActionFactory.class);
//        mockStatic(GameStateMachine.class);
//
//        whenNew(GameStateTableBuilder.class).withNoArguments().thenReturn(gameStateTableBuilder);
//        whenNew(GameActionFactory.class).withNoArguments().thenReturn(gameEventFactory);
//
//        when(gameStateTableBuilder.build()).thenReturn(stateTable);
//
//        StateMachine stateMachine = GameStateMachineBuilder.getInstance().build();
//
//        assertThat(stateMachine).isInstanceOf(GameStateMachine.class);
//
//        verify(gameStateTableBuilder).build();
//
//        verifyNew(GameStateMachine.class).withArguments(stateTable, gameEventFactory);
//    }
//
//}
