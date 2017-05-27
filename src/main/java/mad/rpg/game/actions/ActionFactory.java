package mad.rpg.game.actions;

import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;

public interface ActionFactory {

    Action createAction(StateType state) throws StateNotFoundException;

}
