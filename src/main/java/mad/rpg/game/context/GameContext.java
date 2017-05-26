package mad.rpg.game.context;

import mad.rpg.characters.model.Character;
import mad.rpg.game.events.EventType;

import java.util.ArrayList;
import java.util.List;

public class GameContext implements Context {

    List<EventType> events;
    Character player = null;

    public GameContext() {
        events = new ArrayList<>();
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
    public Context setPlayer(Character player) {
        this.player = player;
        return this;
    }

    @Override
    public Character getPlayer() {
        return player;
    }
}
