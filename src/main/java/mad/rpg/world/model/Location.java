package mad.rpg.world.model;

import mad.rpg.characters.model.HostileCharacter;

import java.util.Optional;

public interface Location {

    Integer getX();

    Integer getY();

    Optional<HostileCharacter> hostile();
}
