package mad.rpg.characters.model;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    CharacterRepository add(Character player);

    List<Character> characters();

    Optional<Character> character(Integer index);
}
