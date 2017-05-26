package mad.rpg.game.transitions;

import mad.rpg.game.context.Context;
import mad.rpg.game.states.StateType;

public interface Transition {

    StateType from();

    StateType to();

    Boolean condition(Context context);

}
