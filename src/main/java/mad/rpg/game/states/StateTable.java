package mad.rpg.game.states;

import mad.rpg.game.context.Context;
import mad.rpg.game.transitions.Transition;

import java.util.List;
import java.util.Optional;

public interface StateTable {

    List<Transition> transitions();

    Optional<Transition> availableTransition(StateType from, Context context);
}
