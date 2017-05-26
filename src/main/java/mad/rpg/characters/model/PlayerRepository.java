package mad.rpg.characters.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerRepository implements CharacterRepository {

    List<Character> characters;

    public PlayerRepository() {
        characters = new ArrayList<>();
    }

    @Override
    public CharacterRepository add(Character player) {
        characters.add(player);
        return this;
    }

    @Override
    public List<Character> characters() {
        return characters;
    }

    @Override
    public Optional<Character> character(Integer index) {
        return characters.stream().skip(index.longValue() - 1).findFirst();
    }

}
