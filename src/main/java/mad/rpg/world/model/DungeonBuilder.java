package mad.rpg.world.model;

public class DungeonBuilder implements WorldBuilder {

    private static final Integer LOCATION_ARRAY_SIZE = 5;

    @Override
    public World build() {
        Location[][] locations = new Room[LOCATION_ARRAY_SIZE][LOCATION_ARRAY_SIZE];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Room(i, j);
            }
        }
        return new Dungeon(locations);
    }

}
