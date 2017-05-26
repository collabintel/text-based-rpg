package mad.rpg.game;

import mad.rpg.game.states.GameStateMachineBuilder;
import mad.rpg.game.states.StateMachine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameStateMachineBuilder.class})
public class ApplicationTest {

    @Mock
    GameStateMachineBuilder gameStateMachineBuilder;

    @Mock
    StateMachine stateMachine;

    @Test
    public void should_runApplication_when_mainCalled() throws Exception {
        PowerMockito.mockStatic(GameStateMachineBuilder.class);
        PowerMockito.when(GameStateMachineBuilder.getInstance()).thenReturn(gameStateMachineBuilder);
        when(gameStateMachineBuilder.build()).thenReturn(stateMachine);

        Application.main(null);

        verify(stateMachine).run();

    }
}
