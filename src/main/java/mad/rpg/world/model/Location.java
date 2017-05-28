package mad.rpg.world.model;

import mad.rpg.characters.model.HostileCharacter;

import java.io.Serializable;
import java.util.Optional;

public interface Location extends Serializable {

    Integer getX();

    Integer getY();

    Optional<HostileCharacter> hostile();
}
