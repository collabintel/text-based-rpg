package mad.rpg.world.model;

import java.io.Serializable;

public interface World extends Serializable {

    Location[][] locations();

    Location currentLocation();

    Boolean changeLocation(Directions direction);

    Integer currentLocationIndex();
}
