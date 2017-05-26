package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.game.events.EventType;

public interface Context {

    Context addEvent(EventType command);

    EventType getLastEvent();

    Context setPlayer(Character character);

    Character getPlayer();

}
