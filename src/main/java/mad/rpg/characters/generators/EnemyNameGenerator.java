package mad.rpg.characters.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyNameGenerator {

    Random random;

    List<String> names;

    public EnemyNameGenerator() {
        random = new Random();
        names = new ArrayList<>();
        names.add("Ogre");
        names.add("Orc");
        names.add("Goblin");
        names.add("Troll");
        names.add("Dragon");
    }

    public String generateName() {
        return names.get(random.nextInt(5));
    }

}
