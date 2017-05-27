package mad.rpg.world.model;

public interface World {

    Location[][] locations();

    Location currentLocation();

    Boolean changeLocation(Directions direction);

    Integer currentLocationIndex();
}
