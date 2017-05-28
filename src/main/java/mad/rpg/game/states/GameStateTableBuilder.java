package mad.rpg.game.states;

import mad.rpg.battle.conditions.EnemyDefeatedCondition;
import mad.rpg.battle.conditions.EnemyFoundInRoomCondition;
import mad.rpg.battle.conditions.PlayerDefeatedCondition;
import mad.rpg.battle.conditions.PlayerRanAwayCondition;
import mad.rpg.characters.conditions.CharacterCreationBeginCondition;
import mad.rpg.characters.conditions.CharacterCreationEndCondition;
import mad.rpg.characters.conditions.CharacterSelectedCondition;
import mad.rpg.game.conditions.ExitRequestedCondition;
import mad.rpg.game.conditions.GameBuiltCondition;
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
        transitions.add(new StateTransition(StateType.CHARACTER_LISTING_STATE, StateType.GAME_BUILDING_STATE, new CharacterSelectedCondition()));
        transitions.add(new StateTransition(StateType.GAME_BUILDING_STATE, StateType.EXPLORATION_STATE, new GameBuiltCondition()));
        transitions.add(new StateTransition(StateType.EXPLORATION_STATE, StateType.GAME_ENDING_STATE, new ExitRequestedCondition()));
        transitions.add(new StateTransition(StateType.EXPLORATION_STATE, StateType.BATTLE_STATE, new EnemyFoundInRoomCondition()));
        transitions.add(new StateTransition(StateType.BATTLE_STATE, StateType.EXPLORATION_STATE, new EnemyDefeatedCondition()));
        transitions.add(new StateTransition(StateType.BATTLE_STATE, StateType.EXPLORATION_STATE, new PlayerRanAwayCondition()));
        transitions.add(new StateTransition(StateType.BATTLE_STATE, StateType.GAME_ENDING_STATE, new PlayerDefeatedCondition()));
        transitions.add(new StateTransition(StateType.BATTLE_STATE, StateType.GAME_ENDING_STATE, new ExitRequestedCondition()));

        return new GameStateTable(transitions);
    }

}
