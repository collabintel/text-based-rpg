package mad.rpg.world.model;

import mad.rpg.characters.model.HostileCharacter;

import java.util.Optional;

public class Room implements Location {

    private Integer x;
    private Integer y;
    private HostileCharacter enemy;

    public Room(Integer x, Integer y, Optional<HostileCharacter> enemy) {
        this.x = x;
        this.y = y;
        this.enemy = enemy.isPresent() ? enemy.get() : null;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public Optional<HostileCharacter> hostile() {
        return Optional.ofNullable(enemy);
    }
}
