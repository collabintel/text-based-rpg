package mad.rpg.game.transitions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.states.StateType;

public class StateTransition implements Transition {

    StateType from;
    StateType to;
    Condition condition;

    public StateTransition(StateType from, StateType to, Condition condition) {
        this.from = from;
        this.to = to;
        this.condition = condition;
    }

    @Override
    public StateType from() {
        return from;
    }

    @Override
    public StateType to() {
        return to;
    }

    @Override
    public Boolean condition(Context context) {
        return condition.test(context);
    }

}
