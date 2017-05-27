package mad.rpg.game.states;

import mad.rpg.characters.conditions.CharacterCreationBeginCondition;
import mad.rpg.characters.conditions.CharacterCreationEndCondition;
import mad.rpg.game.conditions.ExitRequestedCondition;
import mad.rpg.game.conditions.NoCondition;
import mad.rpg.game.transitions.StateTransition;
import mad.rpg.game.transitions.Transition;

import java.util.ArrayList;
import java.util.List;

public class GameStateTableBuilder implements StateTableBuilder {

    @Override
    public StateTable build() {
        List<Transition> transitions = new ArrayList<>();
        transitions.add(new StateTransition(StateType.EMPTY_STATE, StateType.GAME_BEGINNING_STATE, new NoCondition()));
        transitions.add(new StateTransition(StateType.GAME_BEGINNING_STATE, StateType.CHARACTER_LISTING_STATE, new NoCondition()));
        transitions.add(new StateTransition(StateType.CHARACTER_LISTING_STATE, StateType.GAME_ENDING_STATE, new ExitRequestedCondition()));
        transitions.add(new StateTransition(StateType.CHARACTER_LISTING_STATE, StateType.CHARACTER_CREATING_STATE, new CharacterCreationBeginCondition()));
        transitions.add(new StateTransition(StateType.CHARACTER_CREATING_STATE, StateType.CHARACTER_LISTING_STATE, new CharacterCreationEndCondition()));
        transitions.add(new StateTransition(StateType.CHARACTER_CREATING_STATE, StateType.GAME_ENDING_STATE, new ExitRequestedCondition()));

        return new GameStateTable(transitions);
    }

}
