package mad.rpg.game.actions;

import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;

public interface EventFactory {

    Action createEvent(StateType state) throws StateNotFoundException;

}
