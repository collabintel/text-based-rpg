package mad.rpg.game.states;

import mad.rpg.game.context.Context;
import mad.rpg.game.transitions.Transition;

import java.util.List;
import java.util.Optional;

public class GameStateTable implements StateTable {

    private List<Transition> transitions;

    public GameStateTable(List<Transition> transitions) {
        this.transitions = transitions;
    }

    @Override
    public List<Transition> transitions() {
        return transitions;
    }

    @Override
    public Optional<Transition> availableTransition(StateType from, Context context) {
        return transitions
                .stream()
                .filter(transition -> transition.from().equals(from) && transition.condition(context))
                .findFirst();
    }

}
