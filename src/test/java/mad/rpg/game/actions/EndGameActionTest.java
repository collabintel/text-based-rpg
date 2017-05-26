package mad.rpg.game.actions;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.utils.Output;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Output.class})
public class EndGameActionTest {

    @Mock
    private Output output;

    private Action endGameAction;

    private Context gameContext;

    @Before
    public void setUp() throws Exception {
        endGameAction = new EndGameAction();
        PowerMockito.mockStatic(Output.class);
        PowerMockito.when(Output.getInstance()).thenReturn(output);
        gameContext = new GameContext();
    }

    @Test
    public void should_printWelcomeMessage_when_executeCalled() throws Exception {
        endGameAction.process(gameContext);

        verify(output).printMessage(Messages.EXIT_GAME);
    }
}
