package mad.rpg.game.states;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.game.actions.Action;
import mad.rpg.game.actions.EventFactory;
import mad.rpg.game.transitions.Transition;
import mad.rpg.utils.Output;

import java.util.Optional;

public class GameStateMachine implements StateMachine {

    private StateTable stateTable;
    private EventFactory eventFactory;
    private Context context;

    public GameStateMachine(StateTable stateTable, Context context, EventFactory eventFactory) {
        this.stateTable = stateTable;
        this.eventFactory = eventFactory;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            StateType state = StateType.EMPTY_STATE;

            while(state != StateType.GAME_ENDING_STATE){
                Optional<Transition> transition = stateTable.availableTransition(state, context);

                if(transition.isPresent()){
                    state = transition.get().to();
                }
                Action action = eventFactory.createEvent(state);
                action.process(context);
            }
        } catch (StateNotFoundException e) {
            Output.getInstance().printMessage(e.getMessage());
            Output.getInstance().printMessage(Messages.UNHANDLED_OPERATION);
        }
    }
}
