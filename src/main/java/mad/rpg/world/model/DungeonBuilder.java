package mad.rpg.world.model;

import java.util.Random;

public class DungeonBuilder implements WorldBuilder {

    Random random;

    public DungeonBuilder() {
        random = new Random();
    }

    @Override
    public World build() {
        Integer arraySize = random.nextInt(6) + 5;
        Location[][] locations = new Room[arraySize][arraySize];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Room(i, j);
            }
        }
        return new Dungeon(locations);
    }

}
