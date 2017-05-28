package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.game.events.EventType;
import mad.rpg.world.model.World;

import java.io.Serializable;
import java.util.List;

public interface Context extends Serializable {

    List<EventType> events();

    Context addEvent(EventType command);

    EventType getLastEvent();

    Context withPlayer(Character character);

    Character getPlayer();

    Context withWorld(World world);

    World getWorld();

}
