package mad.rpg.game.states;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.actions.ActionFactory;
import mad.rpg.game.actions.GameActionFactory;

public class GameStateMachineBuilder {

    StateTableBuilder stateTableBuilder;
    ActionFactory actionFactory;
    Context context;

    protected GameStateMachineBuilder() {
        stateTableBuilder = new GameStateTableBuilder();
        actionFactory = new GameActionFactory();
        context = new GameContext();
    }

    private static final class GameStateMachineBuilderNested {
        private static final GameStateMachineBuilder INSTANCE = new GameStateMachineBuilder();
    }

    public static GameStateMachineBuilder getInstance() {
        return GameStateMachineBuilderNested.INSTANCE;
    }

    public StateMachine build() {
        StateTable stateTable = stateTableBuilder.build();
        return new GameStateMachine(stateTable, context, actionFactory);
    }
}
