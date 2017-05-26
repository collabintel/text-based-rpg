package mad.rpg.game.states;

import mad.rpg.game.Messages;

public class StateNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return Messages.STATE_NOT_FOUND_EXCEPTION_MESSAGE;
    }

}
