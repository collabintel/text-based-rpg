package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.game.events.EventType;
import mad.rpg.world.model.World;

import java.util.ArrayList;
import java.util.List;

public class GameContext implements Context {

    List<EventType> events;
    Character player = null;
    World world = null;

    public GameContext() {
        events = new ArrayList<>();
    }

    @Override
    public List<EventType> events() {
        return events;
    }

    @Override
    public Context addEvent(EventType event) {
        events.add(event);
        return this;
    }

    @Override
    public EventType getLastEvent() {
        return events.get(events.size() - 1);
    }

    @Override
    public Context withPlayer(Character player) {
        this.player = player;
        return this;
    }

    @Override
    public Character getPlayer() {
        return player;
    }

    @Override
    public Context withWorld(World world) {
        this.world = world;
        return null;
    }

    @Override
    public World getWorld() {
        return world;
    }
}
