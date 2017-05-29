package mad.rpg.game.actions;

import mad.rpg.battle.actions.FightAction;
import mad.rpg.characters.actions.ChooseCharacterAction;
import mad.rpg.characters.actions.CreateCharacterAction;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.model.PlayerRepository;
import mad.rpg.game.saves.SaveGameRepository;
import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;
import mad.rpg.world.actions.ExploreAction;
import mad.rpg.world.model.DungeonBuilder;
import mad.rpg.world.model.WorldBuilder;

public class GameActionFactory implements ActionFactory {

    private CharacterRepository playerRepository;
    private WorldBuilder worldBuilder;
    private SaveGameRepository saveGameRepository;

    public GameActionFactory() {
        playerRepository = new PlayerRepository();
        worldBuilder = new DungeonBuilder();
        saveGameRepository = new SaveGameRepository();
    }

    @Override
    public Action create(StateType stateType) throws StateNotFoundException {
        if(stateType == null){
            throw new StateNotFoundException();
        }
        switch (stateType) {
            case EMPTY_STATE:
                break;
            case GAME_ENDING_STATE:
                return new EndGameAction();
            case CHARACTER_LISTING_STATE:
                return new ChooseCharacterAction(playerRepository);
            case CHARACTER_CREATING_STATE:
                return new CreateCharacterAction(playerRepository);
            case GAME_BEGINNING_STATE:
                return new BeginGameAction(saveGameRepository);
            case EXPLORATION_STATE:
                return new ExploreAction();
            case BATTLE_STATE:
                return new FightAction(playerRepository);
            case GAME_LOADING_STATE:
                return new LoadGameAction(saveGameRepository, playerRepository);
            case GAME_SAVING_STATE:
                return new SaveGameAction(saveGameRepository);
            case GAME_BUILDING_STATE:
                return new BuildGameAction(worldBuilder);
        }
        throw new StateNotFoundException();
    }

}
