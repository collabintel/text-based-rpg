package mad.rpg.game.states;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.game.actions.Action;
import mad.rpg.game.actions.ActionFactory;
import mad.rpg.game.transitions.Transition;
import mad.rpg.utils.UtilLocator;

import java.util.Optional;

public class GameStateMachine implements StateMachine {

    private StateTable stateTable;
    private ActionFactory actionFactory;
    private Context context;

    public GameStateMachine(StateTable stateTable, Context context, ActionFactory actionFactory) {
        this.stateTable = stateTable;
        this.actionFactory = actionFactory;
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
                Action action = actionFactory.create(state);
                action.process(context);
            }
        } catch (StateNotFoundException e) {
            UtilLocator.locate().output().printMessage(e.getMessage());
            UtilLocator.locate().output().printMessage(Messages.UNHANDLED_OPERATION);
        }
    }
}
