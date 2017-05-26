package mad.rpg.game.states;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.actions.EventFactory;
import mad.rpg.game.actions.GameEventFactory;

public class GameStateMachineBuilder {

    StateTableBuilder stateTableBuilder;
    EventFactory eventFactory;
    Context context;

    public GameStateMachineBuilder() {
        stateTableBuilder = new GameStateTableBuilder();
        eventFactory = new GameEventFactory();
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
        return new GameStateMachine(stateTable, context, eventFactory);
    }
}
