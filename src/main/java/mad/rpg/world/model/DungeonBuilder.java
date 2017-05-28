package mad.rpg.world.model;

import mad.rpg.characters.model.EnemyCreator;
import mad.rpg.characters.model.HostileCharacterCreator;

import java.util.Optional;
import java.util.Random;

public class DungeonBuilder implements WorldBuilder {

    private Random random;
    private HostileCharacterCreator enemyCreator;

    public DungeonBuilder() {
        random = new Random();
        enemyCreator = new EnemyCreator();
    }

    @Override
    public World build() {
        Integer arraySize = random.nextInt(6) + 5;
        Location[][] locations = new Room[arraySize][arraySize];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Boolean enemyExists = random.nextBoolean();
                locations[i][j] = new Room(i, j, enemyExists ? Optional.of(enemyCreator.create()) : Optional.empty());
            }
        }
        return new Dungeon(locations);
    }

}
