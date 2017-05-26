package mad.rpg.game.states;

import mad.rpg.game.Messages;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateNotFoundExceptionTest {

    @Test
    public void should_returnStateNotFoundExceptionMessage_when_getMessageCalled() throws Exception {
        StateNotFoundException stateNotFoundException = new StateNotFoundException();

        assertThat(stateNotFoundException.getMessage()).isEqualTo(Messages.STATE_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
