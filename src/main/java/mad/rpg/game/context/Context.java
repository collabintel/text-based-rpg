package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.game.events.EventType;
import mad.rpg.world.model.World;

public interface Context {

    Context addEvent(EventType command);

    EventType getLastEvent();

    Context withPlayer(Character character);

    Character getPlayer();

    Context withWorld(World world);

    World getWorld();

}
