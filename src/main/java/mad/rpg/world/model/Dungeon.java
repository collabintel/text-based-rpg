package mad.rpg.world.model;

import mad.rpg.game.Messages;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;

public class Dungeon implements World {

    private Location[][] locations;
    private Location currentLocation;

    public Dungeon(Location[][] locations) {
        this.locations = locations;
        currentLocation = this.locations[0][0];
    }

    @Override
    public Location[][] locations() {
        return locations;
    }

    @Override
    public Location currentLocation() {
        return currentLocation;
    }

    @Override
    public Boolean changeLocation(Directions direction) {
        Integer x = currentLocation.getX();
        Integer y = currentLocation.getY();
        switch (direction) {
            case NORTH:
                if(locations[x].length <= y + 1){
                    UtilLocator.locate().output().printLine(Messages.CANT_GO_THAT_WAY);
                    return false;
                }
                currentLocation = locations[x][y + 1];
                return true;
            case SOUTH:
                if(y.equals(0)){
                    UtilLocator.locate().output().printLine(Messages.CANT_GO_THAT_WAY);
                    return false;
                }
                currentLocation = locations[x][y - 1];
                return true;
            case EAST:
                if(locations.length <= x + 1){
                    UtilLocator.locate().output().printLine(Messages.CANT_GO_THAT_WAY);
                    return false;
                }
                currentLocation = locations[x + 1][y];
                return true;
            case WEST:
                if(x.equals(0)){
                    UtilLocator.locate().output().printLine(Messages.CANT_GO_THAT_WAY);
                    return false;
                }
                currentLocation = locations[x - 1][y];
                return true;
        }
        return false;
    }

    @Override
    public Integer currentLocationIndex() {
        return (currentLocation.getX() + 1) + (currentLocation.getY() * locations.length);
    }
}
