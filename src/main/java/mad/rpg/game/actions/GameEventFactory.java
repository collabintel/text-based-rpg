package mad.rpg.game.actions;

import mad.rpg.characters.actions.ChooseCharacterAction;
import mad.rpg.characters.actions.CreateCharacterAction;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.model.PlayerRepository;
import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;

public class GameEventFactory implements EventFactory {

    private CharacterRepository playerRepository;

    public GameEventFactory() {
        playerRepository = new PlayerRepository();
    }

    @Override
    public Action createEvent(StateType stateType) throws StateNotFoundException {
        if(stateType == null){
            throw new StateNotFoundException();
        }
        switch (stateType) {
            case GAME_ENDING_STATE:
                return new EndGameAction();
            case CHARACTER_LISTING_STATE:
                return new ChooseCharacterAction(playerRepository);
            case CHARACTER_CREATING_STATE:
                return new CreateCharacterAction(playerRepository);
            case GAME_BEGINNING_STATE:
                return new BeginGameAction();
        }
        throw new StateNotFoundException();
    }

}
