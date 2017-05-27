package mad.rpg.game.actions;

import mad.rpg.characters.actions.ChooseCharacterAction;
import mad.rpg.characters.actions.CreateCharacterAction;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.model.PlayerRepository;
import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;
import mad.rpg.world.actions.ExploreAction;
import mad.rpg.world.model.DungeonBuilder;
import mad.rpg.world.model.WorldBuilder;

public class GameActionFactory implements ActionFactory {

    private CharacterRepository playerRepository;
    private WorldBuilder worldBuilder;

    public GameActionFactory() {
        playerRepository = new PlayerRepository();
        worldBuilder = new DungeonBuilder();
    }

    @Override
    public Action createAction(StateType stateType) throws StateNotFoundException {
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
                return new BeginGameAction();
            case EXPLORATION_STATE:
                return new ExploreAction();
            case GAME_BUILDING_STATE:
                return new BuildGameAction(worldBuilder);
        }
        throw new StateNotFoundException();
    }

}
